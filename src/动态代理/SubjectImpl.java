package 动态代理;

public class SubjectImpl implements Subject{
    @Override
    public void doSomething() {
        System.out.println("实现类-实现方法调用");
    }

    @Override
    public void doAnotherThing() {
        System.out.println("实现类-实现方法调用2");
    }

    @Override
    public void hello(String str) {

    }


}
