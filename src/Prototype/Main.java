package Prototype;

// Summary
// - クラス名を指定せずにインスタンスを生成したくなる場合に使用
// - クラスからインスタンスをつくるのではなく、インスタンスをコピーして新しいインスタンスを作る
// Situation1. 種類が多すぎてクラスにまとめられない場合
// Situation2. クラスからのインスタンス生成が難しい場合
// Situation3. フレームワークと生成するインスタンスを分けたい場合


// - ソースの中に利用するクラスの名前が書かれていると、そのクラスと切り離して再利用することはできなくなってしまう


import Prototype.framework.Manager;
import Prototype.framework.Product;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        manager.register("strong message", upen);
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);

        Product p1 = manager.create("strong message");
        p1.use("Hello, world.");
        Product p2 = manager.create("warning box");
        p2.use("Hello, world.");
        Product p3 = manager.create("slash box");
        p3.use("Hello, world.");
    }
}
