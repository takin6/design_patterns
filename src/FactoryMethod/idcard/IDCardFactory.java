package FactoryMethod.idcard;

import FactoryMethod.framework.Factory;
import FactoryMethod.framework.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IDCardFactory extends Factory {
//    private List owners = new ArrayList();
    private HashMap owners = new HashMap();
    private int serial = 100;

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }

    @Override
    protected void registerProduct(Product product) {
//        owners.add( ((IDCard)product).getOwner() );
        IDCard card = (IDCard)product;
        owners.put(card.getSerial(), card.getOwner());
    }

    public HashMap getOwners() {
        return owners;
    }
}
