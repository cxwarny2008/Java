package Factory;

/**
 * 普通工厂类
 *
 * @author
 */
public class SenderFactory {

    /**
     * 产生Sender具体实现类
     *
     * @param classType
     * @return
     */
    public Sender produceSender(String classType) {
        switch (classType) {
            case "mail":
                return new MailSernder();
            case "sms":
                return new SmsSender();
            default:
                return null;
        }
    }
}
