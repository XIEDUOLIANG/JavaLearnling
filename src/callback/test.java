package callback;

/**
 * @author XieDuoLiang
 * @date 2020/11/16 下午4:49
 */
public class test {

    public static void main(String[] args) {
        Teacher teacher = new Teacher(new Student());
        teacher.ask("1+1=?");
    }
}
