package AbstractFactory;

import Factory.Sender;

public interface FactoryProvider {

    public Sender produce();
}
