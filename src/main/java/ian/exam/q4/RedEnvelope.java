package ian.exam.q4;

import java.util.Random;

public class RedEnvelope implements Runnable {
    // 五個人搶三個紅包，總獎金是100
    int remainingPrize = 100;
    int minPrize = 1;
    int count = 3;

    public void run() {
        synchronized (RedEnvelope.class) {
            if (count == 0) {
                System.out.println(Thread.currentThread().getName() + "沒有搶到紅包");
            } else {
                int getPrize = 0;
                if (count == 1) {
                    getPrize = remainingPrize;

                } else {
                    Random random = new Random();
                    int max = remainingPrize - minPrize * (count - 1);
                    getPrize = random.nextInt(max - minPrize + 1) + minPrize;
                }
                count--;
                remainingPrize = remainingPrize - getPrize;
                System.out.println(Thread.currentThread().getName() + "得到了" + getPrize);
            }
        }
    }

    public static void main(String[] args) {
        RedEnvelope redEnvelope = new RedEnvelope();
        Thread thread1 = new Thread(redEnvelope, "1號");
        Thread thread2 = new Thread(redEnvelope, "2號");
        Thread thread3 = new Thread(redEnvelope, "3號");
        Thread thread4 = new Thread(redEnvelope, "4號");
        Thread thread5 = new Thread(redEnvelope, "5號");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
    }


}
