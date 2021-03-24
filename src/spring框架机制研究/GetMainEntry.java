package spring框架机制研究;

/**
 * @author XieDuoLiang
 * @date 2021/2/14 下午6:42
 */
public class GetMainEntry {

    //获取main方法所在类
    public static void main(String[] args) {
        try {
            StackTraceElement[] stackTrace = new RuntimeException().getStackTrace();
            for (StackTraceElement stackTraceElement:stackTrace) {
                if ("main".equals(stackTraceElement.getMethodName())) {
                    System.out.println(stackTraceElement.getMethodName());
                    System.out.println(Class.forName(stackTraceElement.getClassName()));
                    break;
                }
            }
        } catch (ClassNotFoundException e) {

        }
    }
}
