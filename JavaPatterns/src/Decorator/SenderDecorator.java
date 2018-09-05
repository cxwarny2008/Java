package Decorator;

import Factory.Sender;

/**
 * 装饰模式
 */
public class SenderDecorator implements Sender {

    private  Sender sender;

    public  SenderDecorator(Sender sender)
    {
        sender=sender;
    }
    @Override
    public void Send() {
        sender.Send();
        System.out.println("Hello World!");
    }
}
