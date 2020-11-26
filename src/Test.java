import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public void test(int[] x){
        x[2] = 6;
    }
    public static void main(String[] args) throws Exception{

        Map<String,String> map = new HashMap<>();
        System.out.println(map.put("abc","ert"));
        System.out.println(map.put("abc","qwe"));

        /*String re1 = "java\\d"; // 对应的正则是java\d
        System.out.println("java9".matches(re1));
        System.out.println("java10".matches(re1));
        System.out.println("javac".matches(re1));

        String re2 = "java\\D";
        System.out.println("javax".matches(re2));
        System.out.println("java#".matches(re2));
        System.out.println("java5".matches(re2));*/
        /*Map<String,String> map = new HashMap<>(10000000);
        for (int i = 0; i <10000000 ; i++) {
            map.put(String.valueOf(Math.random()*1000000000),"test");
        }
        System.out.println(new SimpleDateFormat("mm:ss:sss").format(new Date()));
        List<String> stringList = new ArrayList<>(map.values());
        System.out.println(new SimpleDateFormat("mm:ss:sss").format(new Date()));
        List<String> stringList1 = map.keySet().stream().map(map::get).collect(Collectors.toList());
        System.out.println(new SimpleDateFormat("mm:ss:sss").format(new Date()));
        int length = 0;
        int length1 = 0;
        for(String str:stringList){
            //System.out.println(str);
            length++;
        }
        for(String str:stringList1){
            length1++;
        }
        System.out.println(length);
        System.out.println(length1);*/

        System.out.println(Long.parseLong("16023155400000"));
        /*byte[] input = new byte[]{(byte) 0xe4,(byte) 0xb8,(byte) 0xad};
        String output = Base64.getEncoder().encodeToString(input);
        System.out.println(output);*/

        byte[] input = new byte[] { (byte) 0xe4, (byte) 0xb8, (byte) 0xad, (byte)0x21 };
        String b64encoded = Base64.getEncoder().encodeToString(input);
        String b64encoded2 = Base64.getEncoder().withoutPadding().encodeToString(input);
        System.out.println(b64encoded);
        System.out.println(b64encoded2);

        System.out.println(Math.max(0,-1));
        Integer integer = Integer.valueOf("100");
        int i = 0;
        System.out.println();

        Double s = 8.00;
        Double a = 0.5;
        System.out.println(s%a == 0.0);

        System.out.println((long)(a * 360000));
        Integer num1 = 4;
        Double num2 = 3.5;
        System.out.println(num1 > num2);

        //Arrays.sort(new int[],new Comparator<>());
        //Collections.sort();
        List<Integer> list = List.of(1,2,3);
        list.forEach(System.out::println);
    }


}


class Hero implements Comparable<Hero>{

    public String name;
    public int hp;
    public int damage;

    public Hero(){};

    public Hero(String name,int hp,int damage){
        this.name = name;
        this.hp = hp;
        this.damage = damage;
    }

    @Override
    public int compareTo(Hero anotherHero){
        if(this.damage<anotherHero.damage)
            return 1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", damage=" + damage +
                '}';
    }
}





