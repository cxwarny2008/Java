package Builder;

import Factory.MailSernder;
import Factory.Sender;
import Factory.SmsSender;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.List;

/**
 * 建造者模式
 */
public class SenderBuilder {

    private List<Sender> senderList = new ArrayList();

    /**
     * 建造MailSender
     *
     * @param count
     */
    public void produceMailSender(int count) {
        for (int i = 0; i < count; i++) {
            senderList.add(new MailSernder());
        }
    }

    /**
     * 建造SmsSender
     * @param count
     */
    public void produceSmsSender(int count) {
        for (int i = 0; i < count; i++) {
            senderList.add(new SmsSender());
        }
    }

    /**
     * 获取senderList
     * @return
     */
    public  List<Sender> getSenderList()
    {
        return  senderList;
    }

}
