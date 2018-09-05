package Factory;

public class ManyStaticFatory {

    public static Sender produceMailSender() {
        return new MailSernder();
    }

    public static Sender produceSmsSender() {
        return new SmsSender();
    }
}

