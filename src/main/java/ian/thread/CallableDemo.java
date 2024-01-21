package ian.thread;

import java.util.concurrent.Callable;

public class CallableDemo implements Callable<Integer> {// <返回值型態>
    public Integer call() throws Exception {
        String name = Thread.currentThread().getName();
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum += i;
        }
        return sum;
    }
}
