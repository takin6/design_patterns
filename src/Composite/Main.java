package Composite;

// Summary
// Composite Pattern: 容器と中身を同一視し、再帰的な構造を作る。容器の中に中身 or 小さな容器を入れる。
//                    ex) ディレクトリの構造

// Actors
// Leaf: 中身を表す役。他のものを入れることはできない。(file class)
// Composite: 容器。Leaf役、Composite役を入れることができる（Directory class）
// Component: Leaf役とComposite役を同一視する為の役。(Entryクラス)

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
            rootdir.printList();

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
            File f = new File("memo.tex", 300);
            hanako.add(f);
            tomura.add(new File("game.doc", 400));
            tomura.add(new File("junk.mail", 500));
            rootdir.printList();

            System.out.println(f.getFullName());
        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
