package Singleton;

// Summary
// Singleton:
//  - 指定したクラスのインスタンスが絶対に一個しか存在しないことを保障したい
//  - インスタンスが一個しか存在しないことをプログラム上で表現したい

// Note
// - getInstanceメソッドを呼び出したときに、Singletonクラスは初期化される。
//   Staticフィールドの初期化が行われ、唯一のインスタンスが作られる。

public class Main {
    public static void main(String[] args) {
        System.out.println("Start.");
        Singleton obj1 = Singleton.getInstance();
        Singleton obj2 = Singleton.getInstance();
        if (obj1 == obj2) {
            System.out.println("obj1 and obj2 are the same");
        } else {
            System.out.println("obj1 and obj are not the same");
        }
    }
}
