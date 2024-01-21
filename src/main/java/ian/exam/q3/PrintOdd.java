package ian.exam.q3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class PrintOdd implements Runnable {
    // 兩個線程共同獲取1~100，只印奇數
    int number = 1;
    Lock lock = new ReentrantLock();

    public void run() {
        while (true) {
            try {
                lock.lock();
                if (number > 100)
                    break;
                else {
                    if (number % 2 != 0) {
                        System.out.println(Thread.currentThread().getName() + " : " + number);
                    }
                    number++;
                }
            } finally {
                lock.unlock();
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
