package com.luv2code.springmvc;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.repository.StudentDao;
import com.luv2code.springmvc.service.StudentAndGradeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource("/application.properties")
@SpringBootTest
public class StudentsAndGradesServiceTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private StudentAndGradeService studentService;

    @Autowired
    private StudentDao studentDao;

    @BeforeEach
    public void setupDatabase() {
        jdbcTemplate.execute("INSERT INTO student(id, firstname, lastname, email_address) VALUES (1, 'Mateusz', 'Marcykiewicz', 'mmarcykiewicz@gmail.com')");
    }

    @AfterEach
    public void doDatabaseCleanUp() {
        jdbcTemplate.execute("DELETE FROM student");
    }

    @Test
    public void createStudentService() {

        studentService.createStudent("Chad", "Darby", "chad.darby@luv2code_school.com");

        CollegeStudent student = studentDao.findByEmailAddress("chad.darby@luv2code_school.com");
//
        assertEquals("chad.darby@luv2code_school.com", student.getEmailAddress(), "find by email");
    }

    @Test
    public void isStudentNullCheck() {
        assertTrue(studentService.checkIfStudentIsNull(1));

        assertFalse(studentService.checkIfStudentIsNull(0));
    }

    @Test
    public void testDeleteStudent() {

        Optional<CollegeStudent> studentOptional = studentDao.findById(1);

        assertTrue(studentOptional.isPresent());

        studentService.deleteById(1);

        var deletedCollegeStudent = studentDao.findById(1);

        assertTrue(deletedCollegeStudent.isEmpty());
    }

    @Sql("/insert-data.sql")
    @Test
    public void getAllStudents() {

       var students = studentService.getAllStudents();
       List<CollegeStudent> allStudentsList = new ArrayList<>();
       students.forEach(allStudentsList::add);

       assertEquals(5, allStudentsList.size());
    }
}
