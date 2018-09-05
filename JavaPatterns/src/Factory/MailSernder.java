package Factory;

/**
 * 发送邮件
 */
public class MailSernder implements Sender {

    /**
     * 发送邮件
     */
    @Override
    public void Send() {
        System.out.println("发送邮件");
    }
}
