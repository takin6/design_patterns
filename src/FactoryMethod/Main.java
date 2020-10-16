package FactoryMethod;

// Summary
// Factory Method: Template Methodパターンでは、スーパークラスがわで処理の骨組みを作り、サブクラス側で具体的な処理の肉付けを行った。
//                 このパターンをインスタンス生成の場面に適用。
// - インスタンスの作り亜k田をスーパークラスの側で定めるが、具体的なクラス名までは決めない
// - 具体的な肉付けは、全てサブクラスの側で行う。

// framework package(Product, Factory) : インスタンス生成の為の枠組み
// idcard package: 実際の肉付け

// Actors
// <<Framework>>
// Creator ->creates Product
// <<Implementation>>
// ConcreateCreator ->create ConcreteProduct

// Pros
// - frameworkパッケージは、製品パッケージ(idcard, television)に依存していない

// Note
// - Design Patternでは、クラスやインターフェースがここの役割を持ち、互いに関連しながら動作している。
//   クラスやインスタンスの相互関係に目を向けるように！！
// - 一般に、デザインパターンを使って、あるクラス群を設計する場合、そのクラス群の捕手を行う人に、
//   設計者の意図したデザインパターンが何であるかを伝わるようにする必要がある。

import FactoryMethod.framework.Factory;
import FactoryMethod.framework.Product;
import FactoryMethod.idcard.IDCardFactory;

public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("takayuki");
        Product card2 = factory.create("yukari");
        Product card3 = factory.create("asahi");
        card1.use();
        card2.use();
        card3.use();
        System.out.println( ((IDCardFactory)factory).getOwners());
    }
}
