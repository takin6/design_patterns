package Facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

// メールアドレスからユーザーのWebページを作成するクラス
public class PageMaker {
    private PageMaker() {}

    public static void makeWelcomePage(String mailaddr, String filename) {
        try {
            Properties mailprop = Database.getProperties("maildata");
            String username = mailprop.getProperty(mailaddr);
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Welcome to " + username + "'s page!");
            writer.paragraph(username + "のページへようこそ。");
            writer.paragraph("メール待っていますね。");
            writer.mailto(mailaddr, username);
            // closeを呼ばないと、最終的にfileにhtmlは出力されない。
            writer.close();
            System.out.println(filename + " is created for " + mailaddr + " (" + username + ")");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void makeLinkPage(String filename) {
        try {
            HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
            writer.title("Link Page");

            Properties props = Database.getProperties("maildata");
            Set<String> keys = props.stringPropertyNames();
            for (String address: keys) {
                writer.mailto(address, props.getProperty(address));
            }

//            Enumeration en = mailprop.propertyNames();
//            while (en.hasMoreElements()) {
//                String mailaddr = (String)en.nextElement();
//                String username = mailprop.getProperty(mailaddr, "(unknown)");
//                writer.mailto(mailaddr, username);
//            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
