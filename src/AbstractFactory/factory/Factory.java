package AbstractFactory.factory;

/// 抽象的な工場を表すクラス（Link, Tray, Pageを作る１）

public abstract class Factory {
    public static Factory getFactory(String classname) {
        Factory factory = null;
        try {
            factory = (Factory)Class.forName(classname).getDeclaredConstructor().newInstance();
        } catch(ClassNotFoundException e) {
            System.err.println("class: " + classname + " not found");
        } catch(Exception e) {
            e.printStackTrace();
        }

        return factory;
    }

    public abstract Link createLink(String caption, String url);
    public abstract Tray createTray(String caption);
    public abstract Page createPage(String title, String author);
    public Page createYahooPage() {
        Link link = createLink("Yahoo!", "http://www.yaoho.com/");
        Page page = createPage("Yahoo!", "Yahoo!");
        page.add(link);
        return page;
    }
}
