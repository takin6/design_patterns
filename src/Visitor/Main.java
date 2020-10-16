package Visitor;

// Summary
// Visitorパターン：データ構造と処理を分離。データ構造の中をめぐり歩く「訪問者」を表すクラスを用意し、そのクラスに処理を任せます。
//                データ構造の方は、訪問者を受け入れるようにする

// Actors
// Visitor: データ構造の具体的な要素ごとに、xxxを訪問したというvisit(xxx)メソッドを宣言
// ConcreteVisitor: Visitor役のAPIを実装
// Element: Visitor役の訪問先。acceptメソッドを宣言
// ConcreteElement: Element役のAPIを実装する。
// ObjectStructure: Element役の集合を扱う。ConcreteVisitor役が個々のElement役を扱えるようなメソッドを備えている。

// Note
// - Double Dispatch: 二重の振り分け。elementはvisitorをaccept、visitorはelementをvisit
// - 処理をデータから分離する為のデザインパターン。部品(concrete element)の部品としての族立性を高めている。
// - The Open-Closed Principle (OCP): クラスなどは、拡張について開かれているが、修正については閉じられているべき。
// - Visitorが処理をする為の情報に何が必要かを意識する必要がある。ie. directoryの中のここのエントリーを得る為のiteratorメソッド

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Making root entries...");
            Directory rootdir = new Directory("root");
            Directory bindir = new Directory("bin");
            Directory tmpdir = new Directory("tmp");
            Directory usrdir = new Directory("usr");
            rootdir.add(bindir);
            rootdir.add(tmpdir);
            rootdir.add(usrdir);
            bindir.add(new File("vi", 10000));
            bindir.add(new File("latex", 20000));
            rootdir.accept(new ListVisitor());

            System.out.println("");
            System.out.println("Making user entries...");
            Directory yuki = new Directory("yuki");
            Directory hanako = new Directory("hanako");
            Directory tomura = new Directory("tomura");
            usrdir.add(yuki);
            usrdir.add(hanako);
            usrdir.add(tomura);
            yuki.add(new File("diary.html", 100));
            yuki.add(new File("Composite.java", 200));
            hanako.add(new File("index.html", 350));
            hanako.add(new File("memo.tex", 300));
            tomura.add(new File("game.doc", 400));
            tomura.add(new File("junk.mail", 500));
            rootdir.accept(new ListVisitor());

            FileFindVisitor ffv = new FileFindVisitor(".html");
            rootdir.accept(ffv);
            System.out.println("HTML files are:");
            Iterator it = ffv.getFoundFiles();
            while (it.hasNext()) {
                File file = (File)it.next();
                System.out.println(file.toString());
            }
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
