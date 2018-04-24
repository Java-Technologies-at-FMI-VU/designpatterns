package lt.vu.mif.javatech.dp.creational;

class HolderSingleton {

    private static class Holder {
        public static final HolderSingleton instance = new HolderSingleton();
    }

    public static HolderSingleton getInstance() {
        return Holder.instance;
    }

    private HolderSingleton() {
        System.out.println("Initializing instance");
    }

    public void doSomething() {
        System.out.format("Doing something with %s%n", this);
    }
    
}

public class SingletonHolderDemo {

    public static void main(String[] args) {
        System.out.println("In main");
        HolderSingleton.getInstance().doSomething();
        HolderSingleton.getInstance().doSomething();
    }

}
