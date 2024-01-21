package ian.exam.q1;

public class Exam1 {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread table1 = new Thread(ticket, "table1");
        Thread table2 = new Thread(ticket, "table2");

        table1.start();
        table2.start();
    }
}
