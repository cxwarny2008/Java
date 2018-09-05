package Observer;

import Factory.Sender;

import java.util.Vector;

public class ObserverNotice implements IObserverNotice {

    private Vector<Sender> senderVector = new Vector<>();

    @Override
    public void add(Sender sender) {
        senderVector.add(sender);
    }

    @Override
    public void remove(Sender sender) {
        senderVector.remove(sender);
    }

    @Override
    public void notifyObservers() {
        for (Sender item : senderVector) {
            item.Send();
        }
    }
}
