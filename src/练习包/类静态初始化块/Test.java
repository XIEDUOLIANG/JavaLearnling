package 练习包.类静态初始化块;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];
        for(Employee e:staff){
            e = new Employee();
            System.out.println(e.getId());
        }
    }
}

class Employee{
    private static int nextId;
    private int id /*= assignId()*/;

    static{
        Random generator = new Random();
        nextId = generator.nextInt(100);
    }

    /*private static int assignId(){
        int r = nextId;
        nextId++;
        return r;
    }*/
    public Employee(){
        id = nextId;
        nextId++;
    }

    public int getId(){
        return id;
    }
}
