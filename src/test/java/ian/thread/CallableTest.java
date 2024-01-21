package ian.thread;

import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    @Test
   public void callTest() throws ExecutionException, InterruptedException {
        // 任務
        CallableDemo callableDemo = new CallableDemo();
        // 管理執行緒
        FutureTask<Integer> future = new FutureTask<Integer>(callableDemo);
        Thread thread = new Thread(future);
        thread.start();

        Integer integer = future.get();
        System.out.println(integer);

    }
}
