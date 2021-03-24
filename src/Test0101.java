import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author XieDuoLiang
 * @date 2020/11/3 下午2:04
 */
public class Test0101 {

    public static void main(String[] args) {
        List<PersonalAppointOrderResp> list1 = new ArrayList<>();
        PersonalAppointOrderResp one = new PersonalAppointOrderResp();
        one.setOrderId("123");
        one.setRefundTime("2020-01-12 12:04:05");
        PersonalAppointOrderResp two = new PersonalAppointOrderResp();
        two.setOrderId("123");
        two.setRefundTime("2020-02-12 12:04:05");
        PersonalAppointOrderResp three = new PersonalAppointOrderResp();
        three.setOrderId("1234");
        three.setRefundTime("2020-02-12 12:04:05");
        list1.add(one);
        list1.add(two);
        list1.add(three);

        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for (PersonalAppointOrderResp data:list1) {
            if (!set.add(data.getOrderId())) {
                list.add(data.getOrderId());
            }
        }
        System.out.println(set);
        for (String orderId:list) {
            int first = -1;
            int second = -1;
            for (int i = 0; i < list1.size(); i++) {
                if (orderId.equals(list1.get(i).getOrderId())) {
                    if (first == -1) first = i;
                    else second = i;
                }
                if (second != -1) {
                    Date dateOne = new Date();
                    Date dateTwo = new Date();
                    try {
                        dateOne = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(list1.get(first).getRefundTime());
                        dateTwo = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(list1.get(second).getRefundTime());
                    } catch (ParseException e) {

                    }
                    if (dateOne.after(dateTwo)) {
                        list1.remove(second);
                    } else {
                        list1.remove(first);
                    }
                    break;
                }
            }
        }
        System.out.println(list1);

        int[] nums = new int[5];
        for (int num:nums) {
            System.out.println(num);
        }
    }
}
