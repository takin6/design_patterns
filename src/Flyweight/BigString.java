package Flyweight;

// BigCharを集めて作った「大きな文字列」を表すクラス
public class BigString {
    private BigChar[] bigchars;

    public BigString(String string, boolean shared) {
        if (shared) {
            initShared(string);
        } else {
            initNotShared(string);
        }
    }

    public void initShared(String string) {
        bigchars = new BigChar[string.length()];
        BigCharFactory factory = BigCharFactory.getInstance();
        for (int i=0; i< bigchars.length; i++) {
            bigchars[i] = factory.getBigChar(string.charAt(i));
        }
    }

    public void initNotShared(String string) {
        bigchars = new BigChar[string.length()];
        for (int i=0; i< bigchars.length; i++) {
            bigchars[i] = new BigChar(string.charAt(i));
        }
    }

    public void print() {
        for (int i=0; i<bigchars.length; i++) {
            bigchars[i].print();
        }
    }
}
