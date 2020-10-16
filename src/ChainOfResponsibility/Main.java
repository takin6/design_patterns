package ChainOfResponsibility;

// Summary
// Chain of Responsibility: たらい回しを表現。ある要求が発生した時に、その要求を処理するオブジェクトをダイレクトに決められない場合
//                          複数のオブジェクトを鎖(チェーン)のように繋いでおき、そのオブジェクトの鎖を順次渡り歩いて目的のオブジェクトを決定する方法

// Actor
// Handler: 処理を要求するAPI。次の人を確保しておき、自分で処理ができない要求がきたら、たらい回しにする
// ConcreteHandler: 要求を処理する具体的な役
// Cient: Main

// Note
// - protected: 同じパッケージのクラス, サブクラスから見える。

public class Main {
    public static void main(String[] args) {
        Support alice = new NoSupport("Alice");
        Support bob = new LimitSupport("Bob", 100);
        Support charlie = new SpecialSupport("Charlie", 429);
        Support diana = new LimitSupport("Diana", 200);
        Support elmo = new OddSupport("Elmo");
        Support fred = new LimitSupport("Fred", 300);

        alice.setNext(bob).setNext(charlie).setNext(diana).setNext(elmo).setNext(fred);
        for (int i=0; i<500; i++) {
            alice.support(new Trouble(i));
        }
    }
}
