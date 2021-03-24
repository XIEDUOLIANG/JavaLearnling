package stream.流的机制研究;

/**
 * @author XieDuoLiang
 * @date 2021/2/15 下午3:53
 */
public interface Stream<T> {

    static <T> MyStream<T> makeEmptyStream() {
        return new MyStream.Builder<T>().isEnd(true).build();
    }
}
