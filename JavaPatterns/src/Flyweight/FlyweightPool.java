package Flyweight;

import Factory.MailSernder;
import Factory.Sender;

import java.util.Vector;

/**
 * 享元模式--连接池
 */
public class FlyweightPool {

    private int defaultSize = 10;

    private static Vector<Sender> poolList;

    private FlyweightPool() {
        for (int i = 0; i < defaultSize; i++) {
            poolList.add(new MailSernder());
        }
    }

    /**
     * 返回对象
     */
    public synchronized static void release(Sender currentSender) {
        if (currentSender != null) {
            poolList.add(currentSender);
        }
    }

    /**
     * @return
     */
    public synchronized static Sender getSenderObj() {
        if (poolList.size() > 0) {
            Sender currentSender = poolList.get(0);
            poolList.remove(currentSender);
            return currentSender;
        }
        return null;
    }
}
