package State;

public class NoonState implements State{
    private static NoonState singleton = new NoonState();
    private NoonState() {}

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
        if (hour != 12) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("金庫使用(昼食時)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("非常ベル(昼食時)");
        context.changeState(UrgentState.getInstance());
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("通常の通話(昼食時)");
    }

    public String toString() {
        return "[昼食時]";
    }
}
