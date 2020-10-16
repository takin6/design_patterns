package Momento;

// Summary
// Momentoパターン：インスタンスの持っている情報を保存しておき、元の状態に戻せるようにすること
//               　プログラムに対して、undo, redo, history, snapshotを行うことができる

// Actors
// Originator(作成者)：自分の現在の状態を保存したい時にmomento役を作る。また、momento役を作った時点に戻す
// Momento(記念品): Originator役の内部情報をまとめます。次の2種類のAPIを持っている
//      1. wide interface: オブジェクトの状態を元に戻すために必要な情報が全て得られるメソッドの集合
//      2. narrow interface: 外部のcaretaker役に見せるもの。内部状態が外部に公開されるのを防ぐ。
// Caretaker: Originator役の状態を保存したい時に、そのことをOriginator役に伝える。(main)

// Note
// - Javaのアクセス制御
//   public: どのクラスからも見える、protected: そのパッケージ&サブクラスから見える、なし：そのパッケージから見える、private: そのクラスから見える
// - Caretaker役はどのタイミングでスナップショットをとるか＆いつUndoするかを決め、Originator役でmomento役を作る＆restoreの仕事を行う

import Momento.game.*;

import java.io.*;

public class Main {
    public static final String SAVEFILENAME = "/Users/inouetakayuki/java_practice/design_patterns/src/Momento/game.bat";

    public static void main(String[] args) {
        Gamer gamer = new Gamer(100);
        Momento momento = loadMomento();
        if (momento != null) {
            System.out.println("前回保存した結果からスタートします。");
        } else {
            System.out.println("新規にスタートします。");
            momento = gamer.createMomento();
        }
        for (int i=0; i<100; i++) {
            System.out.println("===== " + i);
            System.out.println("現状:" + gamer);

            gamer.bet();

            System.out.println("所持金は" + gamer.getMoney() + "円になりました");

            if (gamer.getMoney() > momento.getMoney()) {
                System.out.println("   (だいぶ増えたので、現在の状態を保存しておこう)");
                momento = gamer.createMomento();
                saveMomento(momento);
            } else if (gamer.getMoney() < momento.getMoney()/2) {
                System.out.println("   (だいぶ減ったので、以前の状態に復帰しておこう)");
                gamer.restoreMomento(momento);
            }

            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {}
            System.out.println("");
        }
    }

    public static void saveMomento(Momento momento) {
        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream(SAVEFILENAME));
            out.writeObject(momento);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Momento loadMomento() {
        Momento momento = null;
        try {
            ObjectInput in = new ObjectInputStream(new FileInputStream(SAVEFILENAME));
            momento = (Momento)in.readObject();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return momento;
    }
}
