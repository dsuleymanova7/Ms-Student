package az.pashabank.learningsession.msstudent.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    private Integer id;
    private String name;
    private String lastName;
    private Integer collegeId;
}
