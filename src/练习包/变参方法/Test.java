package 练习包.变参方法;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        /*double m = max(108.9,1.2,3.6,-2.9,12.3,-45.2,78.9,78.3,100.5);
        System.out.println(max(m));*/
        /*String s = "123*123*";
        s = s.replaceFirst("\\*","t");
        System.out.println(s);

        String ss = "aassdd";
        String sss = ss;
        sss = sss+"c";
        System.out.println(ss);
        System.out.println(sss);

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date()));
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
        date = date.replaceAll("-","");
        date = date.replaceAll(" ","");
        date = date.replaceAll(":","");
        System.out.println(date);

        System.out.println(genRandomSeq(6));

        List<Integer> integerList = new ArrayList<>();
        integerList.add(3);
        integerList.add(2);
        integerList.add(5);
        integerList.sort(Comparator.comparing(Integer::intValue).reversed());
        System.out.println(integerList.toString());

        String test="12";
        String test1="1";
        System.out.println(test.length());
        System.out.println(test1.length());*/

        /*List<String> stringList = new ArrayList<>();
        stringList.add("c");
        stringList.add("a");
        stringList.add("b");
        stringList.sort(String::compareTo);
        System.out.println(stringList);

        Stream<String> stream = stringList.stream();
        stream.forEach(Test::test);

        Stream<Integer> stream1 = Stream.generate(new NumberSupplier());
        stream1.limit(1000).forEach(System.out::println);*/

        File f = new File("/Users/xieduoliang");
        File[] files = f.listFiles();
        Stream<File> fileStream = Objects.isNull(files) ? null : Arrays.stream(files);
        if (Objects.nonNull(fileStream)) {
            fileStream
                    .filter(n -> n.toString().contains("Xco"))
                    .forEach(System.out::println);
        }

    }

    static <T> void test(T t) {
        System.out.println(t);
    }

    public static String genRandomSeq(int length) {
        int len = length < 1 ? 4 : length;
        double dd = (1 + Math.random()) * Math.pow(10, len);
        return String.valueOf(dd).substring(1, len + 1);
    }

    static double max(double... zhi) {
        double largest = Double.NEGATIVE_INFINITY;
        for (double e : zhi)
            if (e > largest)
                largest = e;

        return largest;
    }
}

class NumberSupplier implements Supplier<Integer>{

    int n = 0;

    /**
     * Gets a result.
     *
     * @return a result
     */
    @Override
    public Integer get() {
        return n++;
    }
}
