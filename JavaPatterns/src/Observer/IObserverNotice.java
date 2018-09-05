package Observer;

import Factory.Sender;

public interface IObserverNotice {

    /**
     * 新增观察者
     *
     * @param sender
     */
    public void add(Sender sender);

    /**
     * 移除观察者
     * @param sender
     */
    public  void  remove(Sender sender);

    /**
     * 通知所有的观察者
     */
    public void notifyObservers();

}
