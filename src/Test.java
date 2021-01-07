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

public class Test {

    public void test(int[] x){
        x[2] = 6;
    }
    public static void main(String[] args) throws Exception{
        
        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("234");
        String[] strings = new String[list.size()];
        strings = list.toArray(strings);
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





