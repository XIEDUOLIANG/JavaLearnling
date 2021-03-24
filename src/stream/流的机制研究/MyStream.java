package stream.流的机制研究;

import java.util.stream.Stream;

/**
 * @author XieDuoLiang
 * @date 2021/2/14 下午9:20
 */
public class MyStream<T> {

    private T head;

    private NextItemEvalProcess nextItemEvalProcess;

    private boolean isEnd;

    public static class Builder<T> {
        private MyStream<T> target;

        public Builder() {
            this.target = new MyStream<>();
        }

        public Builder<T> head(T head) {
            this.target.head = head;
            return this;
        }

        public Builder<T> isEnd(boolean isEnd) {
            this.target.isEnd = isEnd;
            return this;
        }

        public Builder<T> nextItemEvalProcess(NextItemEvalProcess nextItemEvalProcess) {
            this.target.nextItemEvalProcess = nextItemEvalProcess;
            return this;
        }

        public MyStream<T> build() {
            return target;
        }
    }

    public MyStream<T> eval() {
        return this.nextItemEvalProcess.eval();
    }

    public boolean isEnd() {
        return this.isEnd;
    }
}
