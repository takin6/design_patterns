package State;

public class UrgentState implements State {
    private static UrgentState singleton = new UrgentState();
    private UrgentState() {}

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("金庫使用(非常時)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("非常ベル(非常時)");
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("通常の通話(非常時)");
    }

    public String toString() {
        return "[非常時]";
    }
}
