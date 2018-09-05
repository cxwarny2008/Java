package Flyweight;

import java.util.Hashtable;

public class FlyweightFactory2 {

    private Hashtable flyweights = new Hashtable();

    public FlyweightFactory2() {
    }
    public Flyweight2 getFlyWeight(Object obj) {
        Flyweight2 flyweight = (Flyweight2) flyweights.get(obj);
        if (flyweight == null) {
            //产生新的ConcreteFlyweight
            flyweight = new ConcreteFlyweight2((String) obj);
            flyweights.put(obj, flyweight);
        }
        return flyweight;
    }

    public int getFlyweightSize() {
        return flyweights.size();
    }
}
