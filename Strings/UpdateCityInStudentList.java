package Strings;

import java.util.Arrays;
import java.util.List;

class Student{
    private String name;
    private String city;
    public Student(String name, String city){
        this.city=city;
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public String getCity(){
        return city;
    }
    public void setCity(String city){
        this.city= city;
    }
    public void setName(String name){
        this.name=name;
    }
}

public class UpdateCityInStudentList {
    public static void main(String[] args) {
        List<Student> student=Arrays.asList( new Student("Abhi", "Mumbai"),
        new Student("Abhinav", "Prayagaraj"));
        System.out.println(updateCity(student));
       
    }
    public static int updateCity(List<Student> students){
        int updateCounts=0;
        for (Student student : students) {
            if ("Mumbai".equalsIgnoreCase(student.getCity())) {
                student.setCity("Delhi");
                updateCounts++;
            }
        }
        return updateCounts;
    }
    
}
