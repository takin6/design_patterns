package Momento.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Gamer {
    private int money;
    private List fruits = new ArrayList<>();
    private Random random = new Random();
    private static String[] fruitsname = {"りんご", "ブドウ", "バナナ", "ミカン"};
    public Gamer(int money) {
        this.money = money;
    }
    public int getMoney() {
        return money;
    }
    public void bet() {
        int dice = random.nextInt(6) + 1;
        if (dice == 1) {
            money += 100;
            System.out.println("所持金が増えました");
        } else if (dice == 2) {
            money /= 2;
            System.out.println("所持金が半分になりました");
        } else if (dice == 6) {
            String f = getFruit();
            System.out.println("フルーツ(" + f + ")をもらいました。");
            fruits.add(f);
        }
    }

    public Momento createMomento() {
        Momento m = new Momento(money);
        Iterator it = fruits.iterator();
        while (it.hasNext()) {
            String f = (String)it.next();
            if (f.startsWith("おいしい")) {
                m.addFruit(f);
            }
        }
        return m;
    }

    // Undoを行う
    public void restoreMomento(Momento momento) {
        this.money = momento.money;
        this.fruits = momento.getFruits();
    }

    public String toString() {
        return "[money = " + money + ", fruits = " + fruits + "]";
    }

    public String getFruit() {
        String prefix = "";
        if (random.nextBoolean()) {
            prefix = "おいしい";
        }
        return prefix + fruitsname[random.nextInt(fruitsname.length)];
    }
}
