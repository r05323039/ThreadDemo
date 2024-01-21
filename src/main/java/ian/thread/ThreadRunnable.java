package ian.thread;

public class ThreadRunnable implements Runnable{
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 100; i++) {
            System.out.println(name + i);
        }
    }
}
