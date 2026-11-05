package exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee/api")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    public EmployeeController(){}

    @PostMapping("/postNewEmployee")
    public EmployeeEntity postEmployee(@RequestBody EmployeeEntity employee){
        return service.postEmployee(employee);
    }

    @GetMapping("/getAllEmployees")
    public List<EmployeeEntity> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/getEmployee/{id}")
    public EmployeeEntity getById(@PathVariable("id") int id) {
        return service.getById(id);
    }

    @PutMapping("/putEmployee/{id}")
    public EmployeeEntity putEmployee(@PathVariable("id") int id,
            @RequestBody EmployeeEntity newEmployeeDetails) {
        return service.putEmployee(id, newEmployeeDetails);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") int id) {
        service.deleteEmployee(id);
        return "Done delete";
    }
}
