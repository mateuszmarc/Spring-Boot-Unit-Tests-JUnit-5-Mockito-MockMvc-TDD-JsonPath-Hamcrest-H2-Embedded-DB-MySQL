package com.luv2code.springmvc.service;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.repository.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class StudentAndGradeService {

    @Autowired
    private StudentDao studentDao;

    public void createStudent(String firstName, String lastName, String email) {

        CollegeStudent collegeStudent = new CollegeStudent(firstName, lastName, email);
        collegeStudent.setId(0);
        studentDao.save(collegeStudent);

    }

    public boolean checkIfStudentIsNull(int id) {
        Optional<CollegeStudent> collegeStudentOptional = studentDao.findById(id);

        return collegeStudentOptional.isPresent();
    }

    public void deleteById(int id) {
        studentDao.deleteById(id);
    }

    public Iterable<CollegeStudent> getAllStudents() {

       return studentDao.findAll();
    }
}
