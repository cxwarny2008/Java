package AbstractFactory;

import Factory.Sender;
import Factory.SmsSender;

/**
 *
 */
public class SenderSmsFactory implements FactoryProvider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
