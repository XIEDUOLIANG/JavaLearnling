package 设计模式.callback;

import java.util.Optional;

/**
 * @author XieDuoLiang
 * @date 2021/1/25 下午2:45
 */
public abstract class Task {

    final void executeWith(CallBack callBack) {
        execute();
        Optional.ofNullable(callBack).ifPresent(CallBack::call);
    }

    abstract void execute();
}
