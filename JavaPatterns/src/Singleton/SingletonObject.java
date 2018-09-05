package Singleton;

import Factory.Sender;
import Factory.SmsSender;

/**
 * 单列模式
 */
public class SingletonObject {

    private static Sender _singletonObj = null;

    private static Object _lockObj = new Object();

    /**
     * 单列模式-双重临界检查
     * @return
     */
    public static Sender getInstance() {
        if (_singletonObj == null) {
            synchronized (_lockObj) {
                if (_singletonObj == null) {
                    _singletonObj = new SmsSender();
                }
            }
        }
        return _singletonObj;
    }
}
