package AbstractFactory;

import Factory.MailSernder;
import Factory.Sender;

public class SendMailFactory implements  FactoryProvider {
    @Override
    public Sender produce() {
        return new MailSernder();
    }
}
