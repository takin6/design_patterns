package FactoryMethod.idcard;

import FactoryMethod.framework.Product;

public class IDCard extends Product {
    private String owner;
    private Integer serial;

    // public, private, protectedをconstructorにつけないと、同じパッケージ内のクラスからしかインスタンス生成できなくなる
    IDCard(String owner, Integer serial) {
        System.out.println(serial + ": " + owner + "のカードがあります。");
        this.owner = owner;
        this.serial = serial;
    }

    @Override
    public void use() {
        System.out.println(owner+"のカードを使います");
    }

    public String getOwner() {
        return owner;
    }

    public Integer getSerial() {
        return serial;
    }
}
