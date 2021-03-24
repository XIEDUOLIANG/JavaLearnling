package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author XieDuoLiang
 * @date 2021/2/19 下午10:21
 */
public class TestProxy {

    public static void main(String[] args) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("hello")) {
                    System.out.println("动态代理，入参："+ args[0]);
                }
                return null;
            }
        };
        Subject subject = (Subject) Proxy.newProxyInstance(
                Subject.class.getClassLoader(),
                new Class[] {Subject.class},
                handler
        );
        subject.hello("test");
    }
}
