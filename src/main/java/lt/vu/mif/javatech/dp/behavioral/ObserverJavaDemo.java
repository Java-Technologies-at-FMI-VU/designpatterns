package lt.vu.mif.javatech.dp.behavioral;

import java.util.Observable;

class TopicJava extends Observable {

    private String title = null;

    public void setTitle(String title) {
        this.title = title;
        this.setChanged();
        this.notifyObservers(title);
    }

}

class TopicObserverJava implements java.util.Observer {
    
    private final String name;

    public TopicObserverJava(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.format("%s: reading [%s]%n", name, arg);
    }
    
}

/**
 * ObserverDemo
 * @author valdo
 */
public class ObserverJavaDemo {

    public static void main(String[] args) {
        
        TopicJava t = new TopicJava();
        
        TopicObserverJava o1 = new TopicObserverJava("o1");
        TopicObserverJava o2 = new TopicObserverJava("o2");
        TopicObserverJava o3 = new TopicObserverJava("o3");
        
        t.addObserver(o1);
        t.addObserver(o2);
        t.addObserver(o3);
        
        System.out.format("Observers: %d%n", t.countObservers());
        
        t.setTitle("Some title");
        t.setTitle("Another title");
        
    }
    
}
