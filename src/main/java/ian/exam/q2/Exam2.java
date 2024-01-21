package ian.exam.q2;

import ian.exam.q1.Ticket;

public class Exam2 {
    public static void main(String[] args) {
        Gift gift = new Gift();
        Thread table1 = new Thread(gift, "table1");
        Thread table2 = new Thread(gift, "table2");

        table1.start();
        table2.start();
    }
}
