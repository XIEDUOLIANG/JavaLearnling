import leetcode.datastructure.TreeNode;
import 练习包.Employee;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public void test(int[] x){
        x[2] = 6;
    }
    public static void main(String[] args) throws Exception{

        Double reduce = Stream.of(1d, 300.03d).reduce(20.2d, (acc, n) -> new BigDecimal(acc.toString()).add(new BigDecimal(n.toString())).doubleValue());
        System.out.println(reduce);

        List<String> list1 = new ArrayList<>();
        list1.add("abc");
        list1.add("ert");
        List<String> a2 = list1.stream().filter(x -> x.contains("a")).collect(Collectors.toList());
        System.out.println(a2);
        System.out.println(list1);

        Double d = Double.valueOf("123456123123123.34");
        System.out.println(d.toString());

        double a = 0.03d;
        double b = 0.02d;
        System.out.println(a-b);

        Double a1 = 0.03d;
        Double b1 = 0.02d;
        System.out.println(a1-b1);
        
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("234");
        String[] strings = new String[list.size()];
        strings = list.toArray(strings);

        String str1 = subString("ababab",0,1);
        String str2 = subString("weabqw",2,3);
        System.out.println(str1+" "+str2);
        System.out.println(str1 == str2);
        System.out.println("abab" == "abab");
        System.out.println(-1>>>1);
    }

    public static String subString(String str,int a,int b) {
        return str.substring(a,b);
    }

    private static String testReflect(int i) {
        return String.valueOf(i);
    }

    private int maxDepth = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return maxDepth;
        }

        recursion(root,1);
        return maxDepth;
    }

    public void recursion(TreeNode root,int dept) {
        if (root == null) {
            return;
        }
        
        maxDepth = Math.max(maxDepth,dept);
        int deeper = dept + 1;
        recursion(root.left,deeper);
        recursion(root.right,deeper);
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





