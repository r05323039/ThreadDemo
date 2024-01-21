package ian.exam.q3;

import ian.exam.q2.Gift;

public class Exam3 {
    public static void main(String[] args) {
        PrintOdd odd = new PrintOdd();
        Thread table1 = new Thread(odd, "table1");
        Thread table2 = new Thread(odd, "table2");

        table1.start();
        table2.start();
    }
}
