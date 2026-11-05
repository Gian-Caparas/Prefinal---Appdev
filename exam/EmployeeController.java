package exam;

import java.util.List;

@RestController
@RequestMapping("/employee/api")
public class EmployeeController {
    @Autowired
    EmployeeService service

    public EmployeeController(){}

    @PostMapping("/postNewEmployee")
    public EmployeeEntity postEmployee(@RequestBody EmployeeEntity employee){
        return service.postEmployee(employee);
    }

    @GetMapping("/getAllEmployees")
    public List<EmployeeEntity> getAllEmployees{
        return service.getAllEmployees();
    }

    @GetMapping("/getEmployee/{id}")
    public EmployeeEntity getById(@PathVariable int idnum){
        return service.getById(idnum);
    }

    @PutMapping("/putEmployee/{id}")
    public EmployeeEntity putEmployee(@PathVariable int idnum, @RequestBody EmployeeEntity newEmployeeDetails){
        return service.putEmployee(id, newEmployeeDetails);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable int idnum){
        service.deleteEmployee(idnum);
        return "Done delete";
    }
}
