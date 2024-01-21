package ian.thread;

import org.junit.Test;

public class ThreadDemoTest {
    @Test
    public void TheadDemoTest() {
        ThreadDemo thread1 = new ThreadDemo();
        thread1.setName("T1:");
        ThreadDemo thread2 = new ThreadDemo();
        thread2.setName("T2:");

        thread1.start();
        thread2.start();
    }

    @Test
    public void RunnableTest() {
        Thread thread1 = new Thread(new ThreadRunnable());
        thread1.setName("T1:");
        Thread thread2 = new Thread(new ThreadRunnable());
        thread2.setName("T2:");

        thread1.start();
        thread2.start();
    }
}
