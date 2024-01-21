package ian.comsume_supply.arrayBlockingQueneDemo;


import java.util.concurrent.ArrayBlockingQueue;

import static ian.comsume_supply.arrayBlockingQueneDemo.Test.remainder;

public class Foodie extends Thread {
    ArrayBlockingQueue<String> queue;

    public Foodie(ArrayBlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (remainder > 0) {
            try {
                String take = queue.take();// take自帶鎖，如果隊列元素為0，自動notify
                remainder--;
                System.out.println("foodie拿走了" + take + "還能吃" + remainder+"碗");//因為sout在鎖外面，導致顯示誤差
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
