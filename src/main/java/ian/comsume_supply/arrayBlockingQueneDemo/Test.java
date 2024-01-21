package ian.comsume_supply.arrayBlockingQueneDemo;

import java.util.concurrent.ArrayBlockingQueue;

public class Test {
    static int remainder = 10;
    public static void main(String[] args) {

        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<String>(3);
        Cook cook = new Cook(queue);
        Foodie foodie = new Foodie(queue);
        cook.start();
        foodie.start();
    }
}
