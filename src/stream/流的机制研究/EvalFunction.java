package stream.流的机制研究;

/**
 * @author XieDuoLiang
 * @date 2021/2/14 下午9:21
 */
@FunctionalInterface
public interface EvalFunction<T> {

    MyStream<T> apply();
}
