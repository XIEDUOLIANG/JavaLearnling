package learningmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author XieDuoLiang
 * @date 2021/1/11 下午4:28
 */
public class MapTest {

    private int[] s;

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        int h = 0;
        System.out.println((h = 1) + h*2);
        System.out.println(Float.isNaN(0.0f/0.1f));
        System.out.println(tableSizeFor(19));
        System.out.println((int) (16 * 0.75f));

        List<String> list = new ArrayList<>();
        List<String> list1 = new LinkedList<>();
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 4: n + 1;
    }
}
