package Factory;

/**
 * 多个工厂方法模式
 */
public class ManySenderFactory {

    public Sender produceMailSender() {
        return new MailSernder();
    }

    public Sender produceSmsSender() {
        return new SmsSender();
    }
}
