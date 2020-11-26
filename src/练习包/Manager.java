package 练习包;

public class Manager extends Employee{
    private double bonus;

    public byte test;

    public Manager(){
        super();
        this.bonus = 2000;
    }

    public void setBonus(double bonus){
        this.bonus = bonus;
    }

    public String getName(){
        return super.getName();
    }

    public double getSalary(){
        double salary = super.getSalary()+this.bonus;
        return salary;
    }


}
