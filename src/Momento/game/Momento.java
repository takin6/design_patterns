package Momento.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Momento implements Serializable {
    int money;
    ArrayList fruits;
    public int getMoney() {
        return money;
    }

    // publicになっていない為、同じパッケージのクラスからしか使うことができない
    Momento(int money) {
        this.money = money;
        this.fruits = new ArrayList();
    }

    void addFruit(String fruit) {
        fruits.add(fruit);
    }

    List getFruits() {
        return (List)fruits.clone();
    }
}
