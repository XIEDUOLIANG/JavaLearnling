package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author XieDuoLiang
 * @date 2021/1/13 下午8:07
 */
public class OOMTest {

    private static class HeapOOM{

    }

    public static void main(String[] args) {
        List<HeapOOM> list = new ArrayList<>();
        while (true) {
            list.add(new HeapOOM());
        }
    }
}
