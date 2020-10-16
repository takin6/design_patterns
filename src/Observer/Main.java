package Observer;

// Summary
// Observer: 観察対象の状態の変化を、観察者(Observer)に対して通知する

// Actors
// Subject: 「観察される側」。Subject役は、観察者であるObserver役を登録&削除するメソッドを持っている。(NumberGenerator)
// ConcreteSubject
// Observer: Subject役から、「状態が変化しましたよ」と教えてもらう役。Updateメソッド
// ConcreteObserver

// Note
// - Design Patternの基礎
//   1. 抽象クラスやインターフェースを使って、具象クラスから抽象メソッドを引き剥がす
//   2. 引数でインスタンスを渡すときや、フィールドでインスタンスを保持する時には、具象クラスの型にしないで、抽象クラスやインタフェースの型にしておく
// - ConcreteObserver役のクラスを設計するときは、updateメソッドが呼び出される順序が変わっても問題がおきないようにする必要がある
// - Observerパターンは、Publish-Subscribeパターンと呼ばれる。Observer役は、能動的に観察するのではなく、Subjectから「通知されるのを受動的に待っている」
// - MVCの中のModelとViewの関係はObserverパターンのSubject、Observer役の関係に対応している

public class Main {
    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
//        NumberGenerator generator = new IncrementalNumberGenerator(10, 30, 2);
        Observer observer1 = new DigitObserver();
        Observer observer2 = new GraphObserver();
        Observer observer3 = new FrameObserver();
        generator.addObserver(observer1);
        generator.addObserver(observer2);
        generator.execute();
    }
}
