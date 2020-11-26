package 练习包;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(){
        name = "moren";
        salary = 3000;
        hireDay = LocalDate.now();
    }

    public Employee(String n,double s,int year,int month,int day){
        name = n;
        salary = s;
        hireDay = LocalDate.of(year,month,day);
    }

    public String getName(){
        return name;
    }

    public double getSalary(){
        return salary;
    }

    public LocalDate getHireDay(){
        return hireDay;
    }

    public void raiseSalary(double byPercent){
        double raise = salary*byPercent/100;
        salary += raise;
    }

    public boolean equals(Object otherObject){
        if(this == otherObject) return true;
        if(otherObject == null) return false;
        if(getClass() != otherObject.getClass()) return false;

        Employee other = (Employee)otherObject;

        return Objects.equals(name,other.name)
                && salary == other.salary
                && Objects.equals(hireDay,other.hireDay);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }
}
