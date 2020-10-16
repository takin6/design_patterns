package Observer;

public class IncrementalNumberGenerator extends NumberGenerator {
    private int startNum;
    private int finishNum;
    private int step;
    private int cur;

    public IncrementalNumberGenerator(int startNum, int finishNum, int step) {
        this.startNum = startNum;
        this.finishNum = finishNum;
        this.step = step;
        this.cur = startNum;
    }

    public int getNumber() {
        return cur;
    }

    public void execute() {
        for (int i=startNum; i<finishNum; i+=step ) {
            cur = i;
            notifyObservers();
        }
    }
}
