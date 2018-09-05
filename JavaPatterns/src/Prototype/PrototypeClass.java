package Prototype;

import java.io.*;

/**
 * 原型链模式、深复制必须可序列化
 */
public class PrototypeClass implements Cloneable, Serializable {

    /**
     * 浅复制
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    public PrototypeClass clone() throws CloneNotSupportedException {
        PrototypeClass prototypeClass = (PrototypeClass) super.clone();
        return prototypeClass;
    }

    /**
     * 深复制
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public PrototypeClass deepClone() throws IOException, ClassNotFoundException {
        /* 写入当前对象的二进制流 */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        /* 读出二进制流产生的新对象 */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (PrototypeClass) ois.readObject();
    }

}
