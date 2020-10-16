package State;

public class NightState implements State {
    private static NightState singleton = new NightState();
    private NightState() {}

    public static State getInstance() {
        return singleton;
    }

    @Override
    public void doClock(Context context, int hour) {
//        if (9 <= hour && hour < 17) {
//            context.changeState(DayState.getInstance());
//        }
        if (hour >= 9 && hour < 12) {
            context.changeState(DayState.getInstance());
        } else if (hour >= 12 && hour < 13) {
            context.changeState(NoonState.getInstance());
        } else if (hour >= 13 && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("金庫使用(夜間)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("非常ベル(夜間)");
        context.changeState(UrgentState.getInstance());
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("通常の通話(夜間)");
    }

    public String toString() {
        return "[夜間]";
    }
}
