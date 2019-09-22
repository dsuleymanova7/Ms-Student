package az.pashabank.learningsession.msstudent.repository;

import az.pashabank.learningsession.msstudent.entity.Student;
import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class StudentRepository {

    private List<Student> students;

    public StudentRepository() {
        students = new ArrayList<>() {
            {
                add(new Student(1, "Durna", "Suleymanova", 1));
                add(new Student(2, "Elvin", "Mahmudov", 2));
                add(new Student(3, "Ayxan", "Agazade", 3));
                add(new Student(4, "Zaur", "Eliyev", 3));


            }
        };
    }
}