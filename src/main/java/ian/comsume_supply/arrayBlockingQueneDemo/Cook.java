package ian.comsume_supply.arrayBlockingQueneDemo;


import java.util.concurrent.ArrayBlockingQueue;

import static ian.comsume_supply.arrayBlockingQueneDemo.Test.remainder;

public class Cook extends Thread {

    ArrayBlockingQueue<String> queue;

    public Cook(ArrayBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (remainder>0) {
            try {
                queue.put("麵條");//放滿隊列自動wait
                System.out.println("cook放了一碗麵條，目前麵條有:"+queue.size());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
