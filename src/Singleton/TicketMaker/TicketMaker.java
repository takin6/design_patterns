package Singleton.TicketMaker;

public class TicketMaker {
    private int ticket = 1000;
    private static TicketMaker singleton = new TicketMaker();

    private TicketMaker() {}

    public static TicketMaker getInstance() {
        return singleton;
    }

    // 複数のスレッドから呼び出されても正しく動くようにする為
    public synchronized int getNextTicketNumber() {
        return ticket++;
    }

}
