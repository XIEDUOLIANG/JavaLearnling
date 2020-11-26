package 反射;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class TestReflection {

    public static void main(String[] args) throws Exception {
        String s1 = "asd";
        String s2 = s1;
        System.out.println(s1);
        System.out.println(s2);
        s2 = "dfg";
        System.out.println(s1);
        System.out.println(s2);

        Person person = new Person();
        person.setName("qwe");
        person.setAge(12);
        person.setGender(true);
        Student student = new Student();
        student.setCode("xdl");
        student.setScore(100);
        List<Game> gameList = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        integerList.add(123);
        integerList.add(678);
        Game game = new Game();
        game.setIntegerList(integerList);
        game.setName("test");
        gameList.add(game);
        student.setGameList(gameList);
        person.setStudent(student);

        Person person1 = new Person();
        copyObj(person,person1);
        System.out.println(person);
        System.out.println(person1);
        //person1.getStudent().getGameList().get(0).setName("test123");
        person1.setStudent(new Student());
        person1.setName("qwe1123");
        person1.setAge(15);
        System.out.println();
        System.out.println(person);
        System.out.println(person1);
    }

    public static void copyObj(Object source, Object target) throws IllegalAccessException {
        Class<?> clazzSource = source.getClass();
        Class<?> clazzTarget = target.getClass();
        for(Field fieldSource:clazzSource.getDeclaredFields()){
            fieldSource.setAccessible(true);
            for(Field fieldTarget:clazzTarget.getDeclaredFields()){
                fieldTarget.setAccessible(true);
                if(fieldSource.getName().equals(fieldTarget.getName())){
                    fieldTarget.set(target,fieldSource.get(source));
                    break;
                }
            }
        }
    }
}
