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
import Observer.IObserverNotice;
import Observer.ObserverNotice;
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

        // 策略模式（strategy）

        //模板方法模式（Template Method）
        //一个抽象类中，有一个主方法，再定义1...n个方法，可以是抽象的，也可以是实际的方法，定义一个类，继承该抽象类，重写抽象方法，通过调用抽象类，实现对子类的调用

        //观察者模式
        IObserverNotice observerNotice = new ObserverNotice();
        observerNotice.add(new MailSernder());
        observerNotice.add(new SmsSender());
        observerNotice.notifyObservers();

        //迭代子模式（Iterator）

        //责任链模式（Chain of Responsibility）

        //命令模式（Command）

        //备忘录模式（Memento）
        //主要目的是保存一个对象的某个状态，以便在适当的时候恢复对象，个人觉得叫备份模式更形象些，

        //状态模式（State）
//当对象的状态改变时，同时改变其行为，很好理解！就拿QQ来说，有几种状态，在线、隐身、忙碌等，每个状态对应不同的操作，

        //访问者模式（Visitor）
//访问者模式把数据结构和作用于结构上的操作解耦合，使得操作集合可相对自由地演化
        //、中介者模式（Mediator）
//中介者模式也是用来降低类类之间的耦合的，因为如果类类之间有依赖关系的话，不利于功能的拓展和维护，因为只要修改一个对象，其它关联的对象都得进行修改。
        //解释器模式（Interpreter）

        System.out.println("Hello World!");
    }
}
