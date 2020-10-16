package AbstractFactory;

// Summary
// AbstractFactory: 「抽象的な工場」抽象的な部品を組み合わせて抽象的な製品を作る。
// - 「抽象的」= 具体的にどのように実装されているかについては考えず、インターフェース(API)だけに注目している
// - 部品の具体的な実装には注目せず、インターフェースに注目する。そして、インターフェースだけを使って部品を組み立て、製品にまとめる。

// Actors
// 1. AbstractProduct: 抽象的な部品や製品のAPI(link,tray,page)
// 2. AbstractFactory: 抽象的な工場(factory)
// 3. Client: AbstractFactory役とAbstractProduct役のインターフェースのみを使って仕事を行う
// 4. ConcreateProduct
// 5. ConcreteFactory

import AbstractFactory.factory.Factory;
import AbstractFactory.factory.Link;
import AbstractFactory.factory.Page;
import AbstractFactory.factory.Tray;

public class Main {

    public static void main(String[] args) {
//        if (args.length != 1) {
//            System.out.println("Usage: java Main class.name.of.ConcreteFactory");
//            System.out.println("Example 1: java Main listfactory.ListFactory");
//            System.out.println("Example 2: java Main tablefactory.TableFactory");
//            System.exit(0);
//        }
//        Factory factory = Factory.getFactory(args[0]);

        Factory factory = Factory.getFactory("AbstractFactory.listfactory.ListFactory");
//        Factory factory = Factory.getFactory("AbstractFactory.tablefactory.TableFactory");

        Link asahi = factory.createLink("朝日新聞", "http://www.asahi.com/");
        Link yomiuri = factory.createLink("読売新聞", "http://www.yomiuri.co.jp/");

        Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
        Link jp_yahoo = factory.createLink("Yahoo! Japan", "http://www.yahoo.co.jp/");
        Link excite = factory.createLink("Excite", "http://www.excite.com/");
        Link google = factory.createLink("Google", "http://www.google.com/");

        Tray traynews = factory.createTray("新聞");
        traynews.add(asahi);
        traynews.add(yomiuri);

        Tray trayyahoo = factory.createTray("Yahoo!");
        trayyahoo.add(us_yahoo);
        trayyahoo.add(jp_yahoo);

        Tray traysearch = factory.createTray("Search Engine");
        traysearch.add(trayyahoo);
        traysearch.add(excite);
        traysearch.add(google);

        Page page = factory.createPage("LinkPage", "井上貴之");
        page.add(traynews);
        page.add(traysearch);
        page.output();
    }
}
