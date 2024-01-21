package ian.comsume_supply;

public class Foodie extends Thread {
    @Override
    public void run() {
        while (Table.remainder > 0) {
            synchronized (Table.lock) {
                if (Table.foodStatus == 1) {
                    Table.remainder--;
                    Table.foodStatus = 0;
                    System.out.println("客人吃了一碗，還能吃 : " + Table.remainder);
                    Table.lock.notifyAll();
                } else {
                    try {
                        Table.lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}
