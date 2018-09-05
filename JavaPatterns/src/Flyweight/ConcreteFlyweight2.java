package Flyweight;

public class ConcreteFlyweight2 extends Flyweight2 {

    private String str;

    public ConcreteFlyweight2(String str) {
        this.str = str;
    }

    @Override
    public void operation() {
        System.out.println("Concrete---Flyweight : " + str);
    }
}
