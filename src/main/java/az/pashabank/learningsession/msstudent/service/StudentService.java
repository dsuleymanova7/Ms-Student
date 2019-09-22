package az.pashabank.learningsession.msstudent.service;

import az.pashabank.learningsession.msstudent.entity.Student;
import az.pashabank.learningsession.msstudent.util.Response;

import java.util.List;

public interface StudentService {
    boolean addStudent(Student student);

    Student getStudentById(Integer id);

    List<Student> getAllStudents();

    boolean update(Student student);

    boolean delete(Integer id);

    List<Student> getAllStudentsByCollegeLocation(String city);


}
