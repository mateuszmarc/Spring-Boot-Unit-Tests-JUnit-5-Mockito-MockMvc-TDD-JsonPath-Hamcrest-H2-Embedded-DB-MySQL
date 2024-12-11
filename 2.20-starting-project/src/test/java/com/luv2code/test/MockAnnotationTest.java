package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.dao.ApplicationDao;
import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import com.luv2code.component.service.ApplicationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class MockAnnotationTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent studentOne;

    @Autowired
    StudentGrades studentGrades;

    @MockBean
    private ApplicationDao applicationDao;

    @Autowired
    ApplicationService applicationService;

    @BeforeEach
    public void beforeEach() {
        studentOne.setFirstname("Mateusz");
        studentOne.setLastname("Marcykiewicz");
        studentOne.setEmailAddress("mmacrykiewicz@gmail.com");
        studentOne.setStudentGrades(studentGrades);
    }

    @DisplayName("When & Verify")
    @Test
    public void assertEqualsTestAddGrades() {

        when(applicationDao.addGradeResultsForSingleClass(studentOne.getStudentGrades().getMathGradeResults())).thenReturn(100.00);

        assertEquals(100, applicationService.addGradeResultsForSingleClass(studentOne.getStudentGrades().getMathGradeResults()));

        verify(applicationDao).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());

        verify(applicationDao, times(1)).addGradeResultsForSingleClass(studentGrades.getMathGradeResults());
    }


    @DisplayName("Test Find GradePointAverage")
    @Test
    public void assertEqualsFindGradePointAverage() {

        when(applicationDao.findGradePointAverage(studentOne.getStudentGrades().getMathGradeResults())).thenReturn(80.00);

        assertEquals(80, applicationService.findGradePointAverage(studentOne.getStudentGrades().getMathGradeResults()));

        verify(applicationDao).findGradePointAverage(studentGrades.getMathGradeResults());
    }

    @DisplayName("Not null")
    @Test
    public void testCheckNotNull() {
        when(applicationDao.checkNull(studentOne.getStudentGrades())).thenReturn(true);

        assertNotNull(applicationService.checkNull(studentOne.getStudentGrades()));

        verify(applicationDao).checkNull(studentOne.getStudentGrades());
    }

    @DisplayName("Throw Exception on check null")
    @Test
    public void testCheckNull() {
        CollegeStudent nullStudent = context.getBean("collegeStudent", CollegeStudent.class);

        doThrow(new RuntimeException()).when(applicationDao).checkNull(nullStudent);

        assertThrows(RuntimeException.class, () -> applicationService.checkNull(nullStudent));

        verify(applicationDao, times(1)).checkNull(nullStudent);
    }

    @DisplayName("Multiple Stubbing")
    @Test
    public void stubbingConsecutiveCalls() {
        CollegeStudent nullStudent = context.getBean("collegeStudent", CollegeStudent.class);

        when(applicationDao.checkNull(nullStudent)).thenThrow(new RuntimeException())
                .thenReturn("This will not throw exception");

        assertThrows(RuntimeException.class, () -> applicationService.checkNull(nullStudent));

        assertEquals("This will not throw exception", applicationService.checkNull(nullStudent));

        verify(applicationDao, times(2)).checkNull(nullStudent);
    }
}
