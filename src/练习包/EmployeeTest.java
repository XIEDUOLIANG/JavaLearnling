package 练习包;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("zhangsan",5000,1997,2,12);
        staff[1] = new Employee("wangwu",6000,2002,3,23);
        staff[2] = new Employee("lisi",3000,2007,5,9);

        for(Employee e:staff){
            System.out.println("员工："+e.getName()+" 入职日期："+e.getHireDay()+" 薪资："+e.getSalary());
        }

        for(Employee e:staff){
            e.raiseSalary(12);
        }

        System.out.println();
        for(Employee e:staff){
            System.out.println("员工："+e.getName()+" 入职日期："+e.getHireDay()+" 薪资："+e.getSalary());
        }

    }
}




