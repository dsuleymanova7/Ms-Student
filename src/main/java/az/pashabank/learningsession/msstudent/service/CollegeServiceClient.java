package az.pashabank.learningsession.msstudent.service;

import az.pashabank.learningsession.msstudent.entity.College;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "collegeServiceClient",url = "localhost:8080/api/college")
public interface CollegeServiceClient {
    @GetMapping("getById/{id}")
    College getCollegeById(@PathVariable("id") Integer id);
}
