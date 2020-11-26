package 异常;

import lombok.Data;

@Data
public class Employee {

    private int id;

    private String name;

    private int age;

    private Double score;

    public Employee(int id, String name, int age, Double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }
}
