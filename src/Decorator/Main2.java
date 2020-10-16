package Decorator;

public class Main2 {
    public static void main(String[] args) {
        MultiStringDisplay md = new MultiStringDisplay();
        md.add("Hello");
        md.add("Good Afternoon");
        md.add("See you later");
        md.show();

        Display d1 = new SideBorder(md, '#');
        Display d2 = new FullBorder(md);
        d2.show();
    }
}
