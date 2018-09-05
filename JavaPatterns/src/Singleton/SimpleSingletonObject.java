package Singleton;

import Factory.MailSernder;
import Factory.Sender;

/**
 * 简单单列模式
 */
public class SimpleSingletonObject {
    private static Sender instance = new MailSernder();

    public static Sender getInstance() {
        return instance;
    }
}
