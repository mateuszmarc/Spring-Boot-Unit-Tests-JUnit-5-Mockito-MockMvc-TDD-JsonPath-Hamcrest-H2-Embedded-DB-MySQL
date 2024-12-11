package com.luv2code.test;

import com.luv2code.test.models.CollegeStudent;
import com.luv2code.test.models.StudentGrades;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest(classes = MvcTestingExampleApplication.class)
class ApplicationExempleTest {

    private int count = 0;

    @Value("${info.app.name}")
    private String appInfo;

    @Value("${info.school.name}")
    private String schoolName;

    @Value("${info.app.description}")
    private String appDescription;

    @Value("${info.app.version}")
    private String appVersion;

    @Autowired
    CollegeStudent student;

    @Autowired
    StudentGrades studentGrades;

    @BeforeEach
    void beforeEach() {
        count += 1;
        System.out.println("Testing: " + appInfo + " which is " + appDescription + " Version: " + appVersion +
                ". Execution of test method " + count);

        student.setFirstname("Eric");
        student.setLastname("Roby");
        student.setEmailAddress("eric.roby@luv2code_school.com");
        studentGrades.setMathGradeResults(new ArrayList<>(Arrays.asList(100.0, 85.0, 76.50, 91.75)));
        student.setStudentGrades(studentGrades);
    }

    @Test
    void basic() {

    }

    @DisplayName("Test adding grade results for student grades")
    @Test
    void testAddGradeResultsForStudentGrades() {
        assertEquals(353.25, studentGrades.addGradeResultsForSingleClass(student.getStudentGrades().getMathGradeResults()));
    }

    @DisplayName("Test adding grade results for student grades not equal")
    @Test
    void testAddGradeResultForStudentGradesNotEqual() {
        assertNotEquals(0, studentGrades.addGradeResultsForSingleClass(student.getStudentGrades().getMathGradeResults()));
    }
}





