package stream.流的机制研究;

/**
 * @author XieDuoLiang
 * @date 2021/2/14 下午9:23
 */
public class NextItemEvalProcess {

    private EvalFunction evalFunction;

    public NextItemEvalProcess(EvalFunction evalFunction) {
        this.evalFunction = evalFunction;
    }

    MyStream eval() {
        return evalFunction.apply();
    }

    public static void main(String[] args) {
        new NextItemEvalProcess((() -> getIntegerStreamInner(1,10,true)));
    }

    private static MyStream<Integer> getIntegerStreamInner(int low, int high, boolean isStart){
        return null;
    }
}
