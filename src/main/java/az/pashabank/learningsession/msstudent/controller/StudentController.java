package az.pashabank.learningsession.msstudent.controller;

import az.pashabank.learningsession.msstudent.entity.Student;
import az.pashabank.learningsession.msstudent.service.StudentService;
import az.pashabank.learningsession.msstudent.util.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentService service;

    private static final Logger LOGGER= LoggerFactory.getLogger(StudentController.class);

    @GetMapping("all")
    public List<Student> getAllStudents(HttpServletRequest request) {
        LOGGER.info("'getAllStudents' requested from " + request.getRemoteAddr() + " ip address");
        return service.getAllStudents();
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable("id") Integer id,HttpServletRequest request) {
        LOGGER.info("'getStudentById' requested from " + request.getRemoteAddr() + " ip address");
        return service.getStudentById(id);
    }

    @PostMapping("add")
    public Response addStudent(@RequestBody Student student,HttpServletRequest request) {
        LOGGER.info("'addStudent' requested from " + request.getRemoteAddr() + " ip address");

        try {
            if (!service.addStudent(student)) {
                throw new Exception();
            }

        } catch (Exception e) {
            return Response.getErrorResponse();
        }
        return Response.getSuccessResponse();
    }

    @PutMapping("update")
    public Response update(@RequestBody Student student,HttpServletRequest request) {
        LOGGER.info("'update' requested from " + request.getRemoteAddr() + " ip address");

        try {
            if (!service.update(student)) {
                throw new Exception();
            }
        } catch (Exception e) {
            return Response.getErrorResponse();
        }
        return Response.getSuccessResponse();

    }

    @DeleteMapping("delete/{id}")
    public Response delete(@PathVariable Integer id, HttpServletRequest request) {
        LOGGER.info("'delete' requested from " + request.getRemoteAddr() + " ip address");
        try {
            if (!service.delete(id)) {
                throw new Exception();
            }

        } catch (Exception e) {
            return Response.getErrorResponse();
        }
        return Response.getSuccessResponse();

    }

    @GetMapping("getByCollegeLocation/{city}")
    public List<Student> getAllStudentsByCollegeLocation(@PathVariable("city") String city,HttpServletRequest request) {
        LOGGER.info("'getAllStudentsByCollegeLocation' requested from " + request.getRemoteAddr() + " ip address");

        return service.getAllStudentsByCollegeLocation(city);
    }
}
