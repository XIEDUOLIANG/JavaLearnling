package 动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Proxy implements InvocationHandler {

    private Object target;

    public Object bind(Object obj){
        this.target = obj;
        return java.lang.reflect.Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),       //类的加载器
                obj.getClass().getInterfaces(),        //代理对象挂在哪个接口下
                this
        );
    }

    /**
     * @param proxy 代理对象
     * @param method 被调用的方法
     * @param args 方法的参数
     * */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("aopBefore");
        result = method.invoke(target,args);           //被代理接口的实现类的方法在这里调用
        if (method.getName().equals("doSomething")) {
            System.out.println(method.getName());
        }
        System.out.println("aopAfter");
        return result;
    }

    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        //1. 将new SubjectImpl()传入Proxy保存起来，Proxy实现InvocationHandler，
        //   重写invoke（很关键，里面可以调用被保存进来的对象的方法，以及在方法前后实现需要的逻辑）
        //2. 通过bind方法返回一个被代理的subject对象
        //3. 接口subject的方法是动态生成字节码实现的
        //4. 上面的步骤可以理解为，生成了一个新的subject接口，里面的方法都有具体实现，
        //   而可以把实现subject接口的类 的方法插入到 subject接口方法的逻辑之间
        //5. 总结一下：java为我们提供了：在运行时，通过动态生成字节码的办法，为接口的方法生成实现方式。
        //   而我们可以巧妙的利用这个特性，实现aop（即以上步骤）
        Subject subject = (Subject) proxy.bind(new SubjectImpl());
        subject.doSomething();
        subject.doAnotherThing();


        //上面步骤3的具体代码实例
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println(method);
                if (method.getName().equals("morning")) {
                    System.out.println("Good morning, " + args[0]);
                }
                return null;
            }
        };
        Hello hello = (Hello) java.lang.reflect.Proxy.newProxyInstance(
                Hello.class.getClassLoader(), // 传入ClassLoader
                new Class[] { Hello.class }, // 传入要实现的接口
                handler); // 传入处理调用方法的InvocationHandler
        hello.morning("Bob");
    }
}

interface Hello {
    void morning(String name);
}
