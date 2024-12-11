package com.luv2code.test;

import com.luv2code.component.MvcTestingExampleApplication;
import com.luv2code.component.models.CollegeStudent;
import com.luv2code.component.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
public class ReflectionUnitTest {

    @Autowired
    ApplicationContext context;

    @Autowired
    CollegeStudent student;

    @Autowired
    StudentGrades grades;

    @BeforeEach
    void beforeEach() {
        student.setFirstname("Mateusz");
        student.setLastname("Marcykiewicz");
        student.setEmailAddress("mmarcykiewicz@gmail.com");
        student.setStudentGrades(grades);


        ReflectionTestUtils.setField(student, "id", 1L);
    }

    @Test
    void getPrivateField() {
        assertEquals(1L, ReflectionTestUtils.getField(student, "id"));
    }

    @Test
    public void testGetFirstNameAndId() {

        String expected = "Id: 1 Mateusz";

        assertEquals(expected, ReflectionTestUtils.invokeMethod(student, "getFirstNameAndId"));
    }
}
