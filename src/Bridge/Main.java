package Bridge;

// Summary
// Bridgeパターン：機能のクラスの階層と、実装のクラスの階層を橋渡しするプログラム
// 「機能のクラスの階層」 : Something Class -> SomethingGood Class -> SomethingBetter Class
// 「実装のクラスの階層」 : 抽象メソッドによってAPIを規定するSuperClass と　APIを実装するSubClass
//                      Abstract Class - Concrete Class
//                                     - AnotherConcrete Class
// => 機能のクラス階層と実装のクラス階層を2つの独立したクラス階層に分けルことによって、見通しをよくする


// Actor
// Abstraction: 「機能のクラス階層」の最上位クラス。Implementor役のメソッドを使って基本的な機能だけが記述されている
// RefinedAbstraction: 「改善した抽象化」
// Implementor: 「実装のクラスの階層」の最上位クラス。Abstraction役のAPIを実装する為のメソッドを規定
// ConcreteImplementor: Imeplementor役のAPIを実装下役

// Note
// 「継承は硬い結びつき、移譲は緩やかな結びつき」
// 継承：extends, 移譲：fieldをもつ

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Display d1 = new Display(new StringDisplayImpl("Hello, Japan"));
        Display d2 = new CountDisplay(new StringDisplayImpl("Hello, World"));
        CountDisplay d3 = new CountDisplay(new StringDisplayImpl("Hello, Universe"));
        RandomDisplay d4 = new RandomDisplay(new StringDisplayImpl("Hello, Random"));
        CountDisplay d5 = new CountDisplay(new FileDisplayImpl("/Users/inouetakayuki/java_practice/design_patterns/src/bridge/demo.txt"));
        d1.display();
        d2.display();
//        ((CountDisplay)d2).multiDisplay(5);
        d3.display();
        d3.multiDisplay(5);
        d4.randomDisplay(10);
        d5.display();

        IncreaseDisplay d6 = new IncreaseDisplay( new CharDisplayImpl('<', '*', '>'), 1);
        d6.increaseDisplay(4);
        IncreaseDisplay d7 = new IncreaseDisplay( new CharDisplayImpl('|', '*', '-'), 2);
        d7.increaseDisplay(6);
    }
}
