package Flyweight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// 大きな文字を表すクラス
public class BigChar {
    private char charname;
    private String fontdata;

    public BigChar(char charname) {
        this.charname = charname;
        try {
            String dir = "/Users/inouetakayuki/java_practice/design_patterns/src/Flyweight/";
            System.out.println(dir + "big"+charname + ".txt");
            BufferedReader reader = new BufferedReader(new FileReader(dir + "big" + charname + ".txt"));
            String line;
            StringBuffer buf = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                buf.append(line);
                buf.append("\n");
            }
            reader.close();
            this.fontdata = buf.toString();
        } catch(IOException e) {
            this.fontdata = charname + "?";
        }
    }

    public void print() {
        System.out.print(fontdata);
    }
}
