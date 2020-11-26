package 类的加载;

/**
 * @author XieDuoLiang
 * @date 2020/8/4 2:53 下午
 */
public class Main {

    public static void main(String[] args) {

        /**
         * jdk:1.8
         * 通过子类引用父类的静态字段,不会导致子类初始化
         */
        //System.out.println(SubClass.value);

        /**
         * jdk：1.8
         * 通过数组定义来引用类，不会触发此类的初始化
         */
        //SuperClass[] superClasses=new SuperClass[10];

        /**
         * jdk：1.8
         * new子类，父类和子类依次初始化
         */
        //new SubClass();

        /**
         * jdk:1.8
         * 常量在编译阶段会存入调用类的常量池，
         * 本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
         */
        //System.out.println(SubClass.TEST);

    }
}
