package ian.exam.q2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Gift implements Runnable {
    // 100份禮品2人同時發送，禮品 < 10 停止發送
    int gift = 100;//發送很快，所以數量太少容易只有一個線程完成
    Lock lock = new ReentrantLock();

    public void run() {
        while (true) {
            lock.lock();
            try {
                if (gift < 10)
                    break;
                else {
                    gift--;
                    System.out.println(Thread.currentThread().getName() + "發送一份禮物，剩下" + gift + "份");
                }
            } finally {
                lock.unlock();
            }
        }
    }
}
