package Adapter.Inheritance;

// Summary
// Adapter ... 必要なものとの間に入ってその間を埋めるのがアダプターの仕事
// Adapter Pattern =/ Wrapper Pattern : 何かをくるりと包んで別の用途に使えるように変換してくれるもの
//  1. クラスによるAdapterパターン(継承を使ったもの)
//  2. インスタンスによるAdapterパターン(移譲を使ったもの)

// 提供されているもの(交流100ボルト)：Bannerクラス
// 交換装置(Adapter) : PrintBannerクラス
// 必要なもの(直流12ボルト): Printインターフェース

// Actors
//  1. Target(対象の役) 今必要となっているメソッドを定めている役：Printインターフェース
//  2. Client(依頼者) Target役のメソッドを使って仕事をする役：Mainクラス
//  3. Adaptee(適合される役) すでに用意されているメソッドを持っているクラス：Bannerクラス
//  4. Adapter: PrintBanner

// When to Use
//  - 既存のクラスに一皮被せて必要とするクラスを作る

public class Main {
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
