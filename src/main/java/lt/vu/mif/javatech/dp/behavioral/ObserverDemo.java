package lt.vu.mif.javatech.dp.behavioral;

import java.util.HashSet;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

abstract class Subject {
    
    private final Set<Observer> observers = new HashSet<>();
    
    public void attach(Observer o) { 
        this.observers.add(o); 
    }
    
    public void detach(Observer o) {
        this.observers.remove(o);
    }
    
    public void notifyObservers() {
        for (Observer o: this.observers) {
            o.update();
        }
    }
    
    public abstract Object getUpdate();
    
}

class Topic extends Subject {

    private String title = null;

    public void setTitle(String title) {
        this.title = title;
        this.notifyObservers();
    }
    
    @Override
    public Object getUpdate() {
        return title;
    }

}

@RequiredArgsConstructor
abstract class Observer {
    
    @Getter(AccessLevel.PROTECTED)
    private final Subject subject;
    
    public abstract void update();
    
}

class TopicObserver extends Observer {
    
    private final String name;

    public TopicObserver(String name, Subject subject) {
        super(subject);
        this.name = name;
    }

    @Override
    public void update() {
        System.out.format("%s: reading [%s]%n", name, getSubject().getUpdate());
    }
    
}

/**
 * ObserverDemo
 * @author valdo
 */
public class ObserverDemo {

    public static void main(String[] args) {
        
        Topic t = new Topic();
        
        Observer o1 = new TopicObserver("o1", t);
        Observer o2 = new TopicObserver("o2", t);
        Observer o3 = new TopicObserver("o3", t);
        
        t.attach(o1);
        t.attach(o2);
        t.attach(o3);
        
        t.setTitle("Some title");
        t.setTitle("Another title");
        
    }
    
}
