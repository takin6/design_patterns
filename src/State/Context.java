package State;

// 金庫の状態変化を管理し、警備センターとの連絡をとるインターフェース
public interface Context {
    public abstract void setClock(int hour);
    public abstract void changeState(State state);
    public abstract void callSecurityCenter(String msg);
    public abstract void recordLog(String msg);
}
