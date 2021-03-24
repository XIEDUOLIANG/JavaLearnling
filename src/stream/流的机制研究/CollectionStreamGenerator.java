package stream.流的机制研究;

import java.util.Iterator;
import java.util.List;

/**
 * @author XieDuoLiang
 * @date 2021/2/15 下午3:56
 */
public class CollectionStreamGenerator {

    public static <T> MyStream<T> getListStream(List<T> list) {
        return getListStream(list.iterator(),true);
    }

    public static <T> MyStream<T> getListStream(Iterator<T> iterator,boolean isStart) {
        if ( ! iterator.hasNext()) {
            return Stream.makeEmptyStream();
        }

        if (isStart) {
            return new MyStream.Builder<T>()
                    .nextItemEvalProcess(new NextItemEvalProcess(() -> getListStream(iterator,false)))
                    .build();
        } else {
            return new MyStream.Builder<T>()
                    .head(iterator.next())
                    .nextItemEvalProcess(new NextItemEvalProcess(() -> getListStream(iterator,false)))
                    .build();
        }
    }
}
