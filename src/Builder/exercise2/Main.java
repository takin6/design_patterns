package Builder.exercise2;

// Summary
// Builder.exercise2パターン：全体を構成している各部品を作り、段階を踏んで組み上げていく

// Actor
// Builder.exercise2 : インスタンスを作成する為のAPIを定める
// ConcreteBuilder.exercise2 : 実装
// Director: Builder.exercise2役のAPIを使ってインスタンスを作成

// Note
// - 誰が何を知っているかを意識する

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            System.exit(0);
        }
        if (args[0].equals("plain")) {
            TextBuilder textbuilder = new TextBuilder();
            Director director = new Director(textbuilder);
            director.construct();
            String result = textbuilder.getResult();
            System.out.println(result);
        } else if (args[0].equals("html")) {
            HtmlBuilder htmlbuilder = new HtmlBuilder();
            Director director = new Director(htmlbuilder);
            director.construct();
            String filename = htmlbuilder.getResult();
            System.out.println(filename + " が作成されました");
        } else {
            usage();
            System.exit(0);
        }
    }

    public static void usage() {
        System.out.println("Usage: java Main plain");
        System.out.println("Usage: java Main html");
    }
}
