import 练习包.Employee;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * @author XieDuoLiang
 * @date 2020/7/20 12:25 下午
 * 对象类型测试
 */
public class ObjTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        List<Person> people = new ArrayList<>();
        Person person = new Person("123");
        Person person1 = new Person("2");
        people.add(person);
        people.add(person1);
        for(Person p:people){
            if(p.getName().equals("123")) {
                people.remove(p);
                break;
            }
        }
        for(Person p:people){
            System.out.println(p);
        }

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        /*Object p = new Person("Xiao Ming");
        Class c = p.getClass();
        Field f = c.getDeclaredField("name");
        f.setAccessible(true);
        Object value = f.get(p);
        System.out.println(value); // "Xiao Ming"

        Employee employee = new Employee();
        employee.setName("q2w");
        getObjType(employee);
        String str = "1,2,3";
        String[] strings = str.split(",");
        for (int i = 0; i <strings.length ; i++) {
            System.out.println(strings[i]);
        }*/



        /*Person person = new Person("xdl");

        List<Student> studentList = new ArrayList<>();
        for (int j = 0; j < 10; j++) {
            Student student = new Student();
            student.setTrue(true);
            studentList.add(student);
        }
        person.setStudentList(studentList);

        List<List<Student>> listList = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            List<Student> studentList1 = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                Student student = new Student();
                student.setTrue(true);
                studentList1.add(student);
            }
            studentList1.get(2).setTrue(false);
            listList.add(studentList1);
        }
        person.setStudentListList(listList);
        getObjType(person);
        System.out.println(new String().getClass().getDeclaredFields().length);*/
    }

    private static void getObjType(Object obj) throws NoSuchFieldException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        
        for(Field field:obj.getClass().getDeclaredFields()){
            field.setAccessible(true);
            if(field.getType().equals(List.class)){
                Type genericType = field.getGenericType();
                if (genericType instanceof ParameterizedType) {
                    ParameterizedType pt = (ParameterizedType) genericType;
                    // 得到泛型里的class类型对象
                    Class<?> actualTypeArgument = null;
                    try{
                        actualTypeArgument = (Class<?>)pt.getActualTypeArguments()[0];
                        System.out.println(actualTypeArgument.getSimpleName());
                        Class clazz = field.get(obj).getClass();
                        Method m = clazz.getDeclaredMethod("size");
                        int size = (Integer) m.invoke(field.get(obj));
                        System.out.println(size);
                        for (int i = 0; i < size; i++) {
                            Method method = clazz.getDeclaredMethod("get",int.class);
                            method.setAccessible(true);
                            for(Field field1:method.invoke(field.get(obj),i).getClass().getDeclaredFields()){
                                if(field1.getName().equals("isTrue")){
                                    field1.setAccessible(true);
                                    //System.out.println(field1.get(method.invoke(field.get(obj),i)));
                                    if(field1.get(method.invoke(field.get(obj),i)) instanceof Boolean){
                                        System.out.println((boolean) field1.get(method.invoke(field.get(obj),i)));
                                    }
                                }
                            }
                        }
                    }catch (ClassCastException e){     //暂时只能处理两层List
                        Class clazz = field.get(obj).getClass();
                        Method m = clazz.getDeclaredMethod("size");
                        int size = (Integer) m.invoke(field.get(obj));
                        for (int i = 0; i < size; i++) {
                            Method method = clazz.getDeclaredMethod("get",int.class);
                            method.setAccessible(true);
                            System.out.println(method.invoke(field.get(obj),i).getClass().getSimpleName());
                            TempClass tempClass = new TempClass();
                            tempClass.setObjectList((List<Object>) method.invoke(field.get(obj), i));
                            getObjType(tempClass);
                        }
                    }


                    /*List<Object> curEleList = new ArrayList<>();
                    Object actualType = actualTypeArgument.newInstance();
                    //....actualType字段处理
                    curEleList.add(actualType);
                    field.set(obj, curEleList);*/
                }
            }
        }

    }
}

class Person {
    private String name;

    private List<Student> studentList;

    private List<List<Student>> studentListList;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<List<Student>> getStudentListList() {
        return studentListList;
    }

    public void setStudentListList(List<List<Student>> studentListList) {
        this.studentListList = studentListList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", studentList=" + studentList +
                ", studentListList=" + studentListList +
                '}';
    }
}


class Student{
     private boolean isTrue;

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }
}

class TempClass{

    private List<Object> objectList;

    public List<Object> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<Object> objectList) {
        this.objectList = objectList;
    }
}