package lt.vu.mif.javatech.dp.creational;

class SimpleSingleton {
    
    private static SimpleSingleton instance = null;

    public static SimpleSingleton getInstance() {
        if (instance == null) {
            instance = new SimpleSingleton();
        }
        return instance;
    }

    private SimpleSingleton() {
        System.out.println("Initializing instance");
    }

    public void doSomething() {
        System.out.format("Doing something with %s%n", this);
    }
    
}

public class SingletonDemo {

    public static void main(String[] args) {
        System.out.println("In main");
        SimpleSingleton.getInstance().doSomething();
        SimpleSingleton.getInstance().doSomething();
    }

}
