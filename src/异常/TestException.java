package 异常;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestException {

    public void testException(int a){
        if(a == 1){
            try {
                throw new MyException("不能传1");
            } catch (MyException e) {
                System.out.println("参数不能为1");
            }
        }
    }

    public static void main(String[] args) {
        /*TestException testException = new TestException();
        testException.testException(1);
        try{
            Integer a = Integer.parseInt("a");
        }catch (NumberFormatException e){
            System.out.println("参数只能是数字");
        }*/

        /*String[] str = {"a","b","y","f","s","w"};
        Arrays.sort(str, (s1,s2) -> {
            return -s1.compareTo(s2);
        });
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        Arrays.sort(str);
        System.out.println(Arrays.toString(str));
        List<String> words = Arrays.asList("i", "love", "you", "my", "friend", "and", "thanks", "!");
        words.stream()
                .filter(strr -> strr.length() < 4)
                .map(strr -> strr + "**")
                .forEach(System.out::println);*/

        //预留集合，方便测试
        List<Employee> emps = Arrays.asList(
                new Employee(102, "李四", 59, 6666.66),
                new Employee(101, "张三", 18, 9999.99),
                new Employee(103, "王五", 28, 3333.33),
                new Employee(104, "赵六", 8, 7777.77),
                new Employee(104, "赵六", 8, 7777.77),
                new Employee(104, "赵六", 8, 7777.77),
                new Employee(105, "田七", 38, 5555.55)
        );


        //1.创建流emps.stream();
        //2.流的中间操作
        //2.1、filter——接收 Lambda ， 从流中排除某些元素。
        Stream<Employee> stream = emps.stream().filter(x -> {
            System.out.println("filter.....");
            return x.getAge() > 18;
        });
        //3.终止流
        //stream.forEach(System.out :: println);
        Stream<String> stringStream = List.of("1","2","3").stream();
        new String("123").lines();
        


    }



}
