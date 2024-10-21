package List;
//Sort a List of Custom Objects

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



class Employee{
    String name;
    double salary;
// Constructor
    public Employee(String name, double salary){
        this.name=name;
        this.salary=salary;
    }
//Getter Setter
   public String getName(){
    return name;
   }

   public double getSalary(){
    return salary;
   }
   public void setSalary(double salary){
    this.salary=salary;
   }
   public void setname(String name){
    this.name=name;
   }
}
public class ShortEmployee {
    
    public static void main(String[] args) {
        List<Employee> employee= Arrays.asList(
            new Employee("Abhinav", 25000),
            new Employee("Tripathi", 12000),
            new Employee("Abhi", 1200)
        );

        //Sort By Name
        List<Employee> sortedByName =employee.stream().sorted(Comparator.comparing(Employee :: getName))
        .collect(Collectors.toList());

        //Sort By Salary
       List<Employee> sortedBySalary= employee.stream().sorted(Comparator.comparing( Employee :: getSalary))
        .collect(Collectors.toList());

        System.out.println("Employee Sorted By Name: "+sortedByName+"\nEmployee Sorted By Salary: "+sortedBySalary);
    }
}
