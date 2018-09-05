package Adapter;

import Factory.MailSernder;
import Factory.Sender;

/**
 * 适配器-对象适配器
 */
public class SenderAdapter2 implements  Targetable {

    private Sender sender;

    public  SenderAdapter2(Sender sender)
    {
        super();
        this.sender=sender;
    }

    /**
     *
     */
    @Override
    public void send() {
        sender.Send();
    }

    @Override
    public void sendNew() {
        System.out.println("sendNew!");
    }
}
