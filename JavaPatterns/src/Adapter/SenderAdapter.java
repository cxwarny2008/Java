package Adapter;

import Factory.MailSernder;

/**
 * 类继承-适配器模式
 */
public class SenderAdapter extends MailSernder implements Targetable {
    @Override
    public void send() {
        send();
    }

    @Override
    public void sendNew() {
        System.out.println("sendNew!");
    }
}
