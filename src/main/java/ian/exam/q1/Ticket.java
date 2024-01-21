package ian.exam.q1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
    //1000張票在2個窗口領取，每次領取間隔3秒
    int tickets = 10;
    Lock lock = new ReentrantLock();

    public void run() {
        while (true) {  // 无限循环，确保线程一直尝试卖票
            lock.lock();//使用靜態變數前，就要鎖起來
            try {
                if (tickets > 0) {  // 检查票数
                    tickets--;
                    System.out.println(Thread.currentThread().getName() + "賣票，剩下" + tickets + "張票");
                } else {
                    break;  // 如果票已经卖完，退出循环
                }
            } finally {
                lock.unlock();
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}