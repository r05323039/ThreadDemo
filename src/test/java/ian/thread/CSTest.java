package ian.thread;

import ian.comsume_supply.Cook;
import ian.comsume_supply.Foodie;
import org.junit.Test;

public class CSTest {
//    @BeforeClass
//    public static void setup(){
//        System.out.println(Table.lock);
//        System.out.println(Table.foodStatus);
//        System.out.println(Table.remainder);
//    }
    @Test
   public void test(){
        Cook cook = new Cook();
        Foodie foodie = new Foodie();

        cook.start();
        foodie.start();
    }
}
