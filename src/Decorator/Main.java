package Decorator;

// Summary
// Decorator パターン：オブジェクトにどんどんデコレーションを施していく

// Actors
// Component: 機能を追加するときの核になる役(Displayクラス)
// ConcreteComponent: Component役のAPIを実装している具体的なクラス（StringDisplay）
// Decorator: Componentと同じAPIをもつ。さらに、Decorator役が飾る対象となるComponent役を持っている。
// ConcreteDecorator: 具体的なDecoratorの役

// Note
// - 飾り役と中身を同一視する。Borderクラスが、中身を表すDisplayクラスのサブクラスになっている。
// - Borderクラスは、中身を表すDisplayクラスと同じAPIを持っている

public class Main {
    public static void main(String[] args) {
        Display b1 = new StringDisplay("Hello, World.");
//        Display b2 = new SideBorder(b1, '#');
        Display b2 = new UpDownBorder(b1, '-');
//        Display b3 = new FullBorder(b2);
        Display b3 = new SideBorder(b2, '*');
        b1.show();
        b2.show();
        b3.show();

        Display b4 =
                new SideBorder(
                        new FullBorder(
                                new FullBorder(
                                        new SideBorder(
                                                new FullBorder(
                                                        new StringDisplay("Hello, World")
                                                ),
                                                '*'
                                        )
                                )
                        ),
                        '/'
                );
        b4.show();
    }
}
