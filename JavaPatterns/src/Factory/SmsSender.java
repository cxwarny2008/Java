package Factory;

/**
 * 发送短信
 */
public class SmsSender implements Sender {

    /**
     * 发送短信
     */
    @Override
    public void Send() {
        System.out.println("发送短信");
    }
}
