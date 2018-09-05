package Proxy;

import Factory.Sender;

/**
 * 代理模式
 */
public class SenderProxy implements Sender {

    private Sender sender;

    public SenderProxy(Sender sender) {
        this.sender = sender;
    }

    @Override
    public void Send() {

        before();
        atfer();

    }

    private void atfer() {
        System.out.println("after proxy!");
    }

    private void before() {
        System.out.println("before proxy!");
    }
}
