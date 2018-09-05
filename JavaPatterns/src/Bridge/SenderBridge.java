package Bridge;


import Factory.Sender;

public abstract class SenderBridge {

    private Sender sender;

    public void send() {
        sender.Send();
    }

    public void setSender(Sender sender) {
        sender = sender;
    }

    public Sender getSender() {
        return sender;
    }
}
