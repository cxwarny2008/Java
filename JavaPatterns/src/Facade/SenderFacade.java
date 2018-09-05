package Facade;

import Factory.MailSernder;
import Factory.Sender;
import Factory.SmsSender;

/**
 * 外观模式
 */
public class SenderFacade {

    private Sender mailSender;

    private Sender smsSender;

    public SenderFacade() {
        mailSender = new MailSernder();
        smsSender = new SmsSender();
    }

    public void send()
    {
        mailSender.Send();
        smsSender.Send();
    }
}
