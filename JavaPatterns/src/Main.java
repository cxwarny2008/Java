import AbstractFactory.FactoryProvider;
import AbstractFactory.SendMailFactory;
import Adapter.AbstractAdapterSub;
import Adapter.SenderAdapter;
import Adapter.SenderAdapter2;
import Adapter.Targetable;
import Bridge.MyBridge;
import Bridge.SenderBridge;
import Builder.SenderBuilder;
import Decorator.SenderDecorator;
import Facade.SenderFacade;
import Factory.MailSernder;
import Factory.Sender;
import Factory.SenderFactory;
import Factory.SmsSender;
import Flyweight.FlyweightFactory2;
import Flyweight.FlyweightPool;
import Prototype.PrototypeClass;
import Proxy.SenderProxy;
import Singleton.SimpleSingletonObject;
import Singleton.SingletonObject;

import javax.lang.model.element.VariableElement;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {

        //普通工厂、多工厂方法、静态工厂
        SenderFactory factory = new SenderFactory();
        Sender mailSender = factory.produceSender("mail");
        mailSender.Send();
        Sender smsSender = factory.produceSender("sms");
        mailSender.Send();

        //抽象工厂
        FactoryProvider provider = new SendMailFactory();
        Sender sender = provider.produce();
        sender.Send();

        //单列模式
        SingletonObject.getInstance().Send();
        SimpleSingletonObject.getInstance().Send();

        //建造者模式
        SenderBuilder senderBuilder = new SenderBuilder();
        senderBuilder.produceMailSender(2);
        senderBuilder.produceSmsSender(3);
        for (Sender senderItem : senderBuilder.getSenderList()) {
            senderItem.Send();
        }
        //PrototypeClass-原型模式
        PrototypeClass prototypeClass = new PrototypeClass();
        PrototypeClass prototypeClass1 = prototypeClass.clone();
        PrototypeClass prototypeClass2 = prototypeClass.deepClone();

        //适配器模式
        //类适配器
        Targetable senderAdapter = new SenderAdapter();
        senderAdapter.send();
        senderAdapter.sendNew();

        //对象适配器
        Targetable senderAdapter2 = new SenderAdapter2(new MailSernder());
        senderAdapter2.send();
        senderAdapter2.sendNew();

        //抽象类适配器
        Targetable abstractAdapterSub = new AbstractAdapterSub();
        abstractAdapterSub.send();

        //装饰模式
        Sender decoratorSender = new SenderDecorator(new SmsSender());
        decoratorSender.Send();

        //代理模式
        Sender senderProxy = new SenderProxy(new MailSernder());
        senderProxy.Send();

        //外观模式
        SenderFacade senderFacade = new SenderFacade();
        senderFacade.send();

        //桥接模式
        SenderBridge senderBridge = new MyBridge();
        senderBridge.setSender(new MailSernder());
        senderBridge.send();

        senderBridge.setSender(new SmsSender());
        senderBridge.send();

        //组合模式-部分与整体

        //元模式--连接池
        Sender flyweightPoolSendeer = FlyweightPool.getSenderObj();
        flyweightPoolSendeer.Send();
        FlyweightPool.release(flyweightPoolSendeer);
        FlyweightFactory2 flyweightFactory2 = new FlyweightFactory2();
        flyweightFactory2.getFlyWeight("Google").operation();



        System.out.println("Hello World!");
    }
}
