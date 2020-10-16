package State;

public class DayState implements State {
    private static DayState singleton = new DayState();
    private DayState() {}

    public static State getInstance() {
        return singleton;
    }
    @Override
    public void doClock(Context context, int hour) {
//        if (hour < 9 || 17 <= hour) {
//            context.changeState(NightState.getInstance());
//        }
        if (hour >= 17 || hour < 9) {
            context.changeState(NightState.getInstance());
        } else if (hour >= 9 && hour < 12) {
            return;
        } else if (hour >= 12 && hour < 13) {
            context.changeState(NoonState.getInstance());
        } else if (hour >= 13 && hour < 17) {
            return;
        }
    }

    @Override
    public void doUse(Context context) {
        context.recordLog("金庫使用(昼間)");
    }

    @Override
    public void doAlarm(Context context) {
        context.callSecurityCenter("非常ベル(昼間)");
        context.changeState(UrgentState.getInstance());
    }

    @Override
    public void doPhone(Context context) {
        context.callSecurityCenter("通常の通話(昼間)");
    }

    public String toString() {
        return "[昼間]";
    }
}
