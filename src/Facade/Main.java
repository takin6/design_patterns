package Facade;

// Summary
// Facade pattern: 複雑に絡み合ってごちゃごちゃした詳細をまとめ、高レベルのAPIを提供。
//                 Facade役は、システムの外に対してはシンプルなAPIを実装。システムの内側にある各クラスの役割・依存関係を考慮し、正しい順番でクラスを利用

// Actor
// - Facade: システムを構成しているその他大勢の役の「シンプルな窓口」
// - システムを構成しているその他大勢の役: Facade役のことは意識せず、独自に仕事を行う（HtmlWriter, Database）
// - Client


// Note
// - Facade役は、複雑なものを単純に見せている。ポイントは、インターフェースを少なくすること。

import Facade.pagemaker.PageMaker;

public class Main {
    public static void main(String[] args) {
        String dir = "/Users/inouetakayuki/java_practice/design_patterns/src/Facade/";
        PageMaker.makeWelcomePage("takayukiinoue116@gmail.com", dir+"welcome.html");

        PageMaker.makeLinkPage(dir+"linkpage.html");
    }

}
