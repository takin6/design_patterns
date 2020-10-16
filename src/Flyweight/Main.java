package Flyweight;

// Summary
// - flyweightは「フライ級」ボクシングでもっとも体重が軽い階級
// - オブジェクトを「軽く」するためのデザインパターン
// - オブジェクトを軽くする = オブジェクトのメモリの使用料を軽くする
// - 「インスタンスを出来るだけ共有させて、無駄にnewしない」
//    => インスタンスが必要な時に、いつもnewするのではなく、すでに作ってあるものを利用しよう！

// Actors
// - Flyweight: 普通に扱うとプログラムが重くなるので共有した方が良いものを表す役
// - FlyweightFactry: Flyweight役を作る工場の役
// - Client

// Note
// - FLyweightパターンでは、どの情報を共有させ、どの情報を共有させないかをよく考える必要がある
// - intrinsicな情報：場所や状況に依存しないので、共有できる
// - extrinsicな情報：場所や状況に依存するので、共有できない
// - Hashmapで管理されているインスタンスはガーベージコレクションの対象にはならない。インスタンスを含むエントリを削除する必要がある。


public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main digits");
            System.out.println("Example: java Main 123123");
        }
        BigString bs = new BigString(args[0], true);
        bs.print();
    }

    public static void showMemory() {
        Runtime.getRuntime().gc();
        long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("使用メモリ = " + used);
    }
}
