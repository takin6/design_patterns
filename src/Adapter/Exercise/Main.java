package Adapter.Exercise;

import java.io.*;

// Summary
// Adapter ... 必要なものとの間に入ってその間を埋めるのがアダプターの仕事
// Adapter Pattern =/ Wrapper Pattern : 何かをくるりと包んで別の用途に使えるように変換してくれるもの
//  1. クラスによるAdapterパターン(継承を使ったもの)
//  2. インスタンスによるAdapterパターン(移譲を使ったもの)

// 提供されているもの(交流100ボルト)：Bannerクラス
// 交換装置(Adapter) : PrintBannerクラス
// 必要なもの(直流12ボルト): Printインターフェース

// Actors
//  1. Target(対象の役) 今必要となっているメソッドを定めている役：FileIO
//  2. Client(依頼者) Target役のメソッドを使って仕事をする役：Main
//  3. Adaptee(適合される役) すでに用意されているメソッドを持っているクラス：java.util.Properties
//  4. Adapter: FileProperties

public class Main {
    public static void main(String[] args) {
        System.out.println("Working Directory = " + System.getProperty("user.dir"));
        FileIO f = new FileProperties();
        try {
            f.readFromFile("/Users/inouetakayuki/java_practice/design_patterns/src/Adapter/Exercise/file.txt");
            f.setValue("year", "2020");
            f.setValue("month", "10");
            f.setValue("day", "16");
            f.writeToFile("/Users/inouetakayuki/java_practice/design_patterns/src/Adapter/Exercise/newfile.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
