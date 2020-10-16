package TemplateMethod;

// Summary
// Template: テンプレートの機能を持つパターン。スーパークラスの方に、テンプレートとなるメソッドが定義されている。
//           メソッドの定義の中では、抽象メソッドが使われている。具体的な処理はサブクラス。
// => スーパークラスで処理の枠組みを定め、サブクラスでその具体的な内容を定めるパターン

// Actor
// AbstractClass : AbstractDisplay
// ConcreteClass : 具象クラス

// Pros
// - サブクラスがわでアルゴリズムをいちいち記述する必要がなくなる
// - スーパークラスの型の変数にサブクラスのインスタンスのどれを代入しても正しく動作するようにする

// memo
// - 抽象クラスは、処理の流れを形つくる.処理の骨組みをつくる（一部のメソッドを実装<=>interfaceではできない）

public class Main {
    public static void main(String[] args) {
        AbstractDisplay d1 = new CharDisplay('H');

        AbstractDisplay d2 = new StringDisplay("Hello World");

        AbstractDisplay d3 = new StringDisplay("こんにちは。");

        d1.display();
        d2.display();
        d3.display();
    }
}
