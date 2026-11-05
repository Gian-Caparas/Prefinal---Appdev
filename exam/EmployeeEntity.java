package exam;

import jakarta.persistence.*;

@Entity 
@Table  (name = "employee")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY);
    private int idnum;
    private String name;
    private String position;
    private double salary;

    public EmployeeEntity(){}
    public EmployeeEntity(String name, String position, double salary){
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setPosition(String position){
        this.position = position;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }

    //getters
    public int getIdNum(){
        return idnum;
    }
    public String getName(){
        return name;
    }
    public String getPosition(){
        return  position;
    }
    public double getSalary(){
        return salary;
    }

}
