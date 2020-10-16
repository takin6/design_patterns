package Prototype.framework;

import java.util.HashMap;


// Productインターフェースを利用して、インスタンスの複製を行う
public class Manager {
    private HashMap showcase = new HashMap();
    public void register(String name, Product proto) {
        showcase.put(name, proto);
    }

    public Product create(String protoname) {
        Product p = (Product)showcase.get(protoname);
        return p.createClone();
    }

}