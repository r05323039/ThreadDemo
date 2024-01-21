package ian.comsume_supply;

public class Cook extends Thread {

    @Override
    public void run() {
        while (Table.remainder > 0) {
            synchronized (Table.lock) {
                if (Table.foodStatus == 0) {
                    System.out.println("廚師製作一碗麵");
                    Table.foodStatus = 1;
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
