package exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRespository repo;

    public EmployeeService(){}

    public EmployeeEntity postEmployee(EmployeeEntity employee){
        return repo.save(employee);
    }

    public List <EmployeeEntity> getAllEmployees(){
        return repo.findAll();
    }

    public EmployeeEntity getById(int idnum){
        return repo.findById(idnum).orElse(null);
    }

    public EmployeeEntity putEmployee(int id, EmployeeEntity newEmployeeDetails) {
        EmployeeEntity employee = new EmployeeEntity();
        try{
            employee = repo.findById(idnum).get();
            employee.setName(newEmployeeDetails.getName());
            employee.setPosition(newEmployeeDetails.getPosition());
            employee.setSalary(newEmployeeDetails.getSalary());
        }catch (NoSuchElementException ex){
            throw new  NameNotFoundException("Employee: " + id + "does now exist!");
        }finally{
            return repo.save(employee); // at table student in database
        }
    }

    public void deleteEmployee(int idnum){
        repo.deleteById(idnum);   
    }
}
