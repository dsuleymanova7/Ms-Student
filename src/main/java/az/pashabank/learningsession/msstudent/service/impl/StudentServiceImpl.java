package az.pashabank.learningsession.msstudent.service.impl;

import az.pashabank.learningsession.msstudent.entity.Student;
import az.pashabank.learningsession.msstudent.repository.StudentRepository;
import az.pashabank.learningsession.msstudent.service.CollegeServiceClient;
import az.pashabank.learningsession.msstudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CollegeServiceClient collegeServiceClient;


    @Override
    public boolean addStudent(Student student) {
        try {
            if (student.getId() == null || student.getName() == null || student.getLastName() == null || student.getCollegeId() == null) {
                throw new Exception();
            }
            studentRepository.getStudents().add(student);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Student getStudentById(Integer id) {
        List<Student> students = studentRepository.getStudents().stream().filter(student -> student.getId().equals(id)).collect(Collectors.toList());
        return students.isEmpty() ? null : students.get(0);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.getStudents().stream().sorted((o1, o2) -> o1.getId().compareTo(o2.getId())).collect(Collectors.toList());

    }

    @Override
    public boolean update(Student student) {
        try {
            if (student.getId() == null || student.getName() == null || student.getLastName() == null || student.getCollegeId() == null) {
                throw new Exception();
            }
            studentRepository.getStudents().removeIf(s -> s.getId().equals(student.getId()));
            studentRepository.getStudents().add(student);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(Integer id) {
        try {
            if (id == null) {
                throw new Exception();
            }
            studentRepository.getStudents().removeIf(s -> s.getId().equals(id));
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public List<Student> getAllStudentsByCollegeLocation(String city) {
        return
                studentRepository.getStudents()
                        .stream()
                        .filter(student -> collegeServiceClient.getCollegeById(student.getCollegeId()).getCity().equals(city))
                        .collect(Collectors.toList());
    }

}
