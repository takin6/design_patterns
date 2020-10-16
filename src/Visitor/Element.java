package Visitor;

// Visitorクラスのインスタンスを受け入れるデータ構造
public interface Element {
    public abstract void accept(Visitor v);
}
