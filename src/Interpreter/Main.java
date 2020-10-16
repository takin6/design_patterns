package Interpreter;

// Summary (Interpreter Pattern)
// - プログラムが解決しようとしている問題を「ミニ言語」で表現
// - 「通訳プログラム(Interpreter)」がミニ言語を理解し、ミニ・プログラムを解釈・実行する

import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        try {
            String dir = "/Users/inouetakayuki/java_practice/design_patterns/src/Interpreter/";
            BufferedReader reader = new BufferedReader(new FileReader(dir + "program.txt"));
            String text;
            while ((text = reader.readLine()) != null) {
                System.out.println("text = \"" + text + "\"");
                Node node = new ProgramNode();
                node.parse(new Context(text));
                System.out.println("node = " + node);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
