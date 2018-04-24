package lt.vu.mif.javatech.dp.behavioral;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

interface Mediator {
    
    Mediator add(Colleague colleague);
    void send(String message, Colleague sender);
    
}

@RequiredArgsConstructor
abstract class Colleague {
    
    @Getter
    private final String name;
    private final Mediator mediator;
    
    public void send(String message) {
        this.mediator.send(message, this);
    }
    
    public abstract void receive(String message, Colleague sender);
    
}

class DesktopColleague extends Colleague {

    public DesktopColleague(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void receive(String message, Colleague sender) {
        System.out.format("%s@Desktop %s: %s%n", getName(), sender.getName(), message);
    }
    
}

class MobileColleague extends Colleague {

    public MobileColleague(String name, Mediator mediator) {
        super(name, mediator);
    }

    @Override
    public void receive(String message, Colleague sender) {
        System.out.format("%s@Mobile %s: %s%n", getName(), sender.getName(), message);
    }
    
}

class SimpleMediator implements Mediator {

    private final List<Colleague> colleagues = new ArrayList<>();
    
    @Override
    public Mediator add(Colleague colleague) {
        this.colleagues.add(colleague);
        return this;
    }
    
    @Override
    public void send(String message, Colleague sender) {
        for (Colleague c: colleagues) {
            if (c != sender) {
                c.receive(message, sender);
            }
        }
    }
    
}

/**
 * MediatorDemo
 * @author valdo
 */
public class MediatorDemo {

    public static void main(String[] args) {
        
        Mediator m = new SimpleMediator();
        
        Colleague c1 = new DesktopColleague("Windows", m);
        Colleague c2 = new DesktopColleague("Linux", m);
        Colleague c3 = new DesktopColleague("Mac", m);
        Colleague c4 = new MobileColleague("iPhone", m);
        Colleague c5 = new MobileColleague("Android", m);
        
        m.add(c1).add(c2).add(c3).add(c4).add(c5);
        
        c3.send("I'm the best!");
        c2.send("I'm free!");
        c1.send("Still... I'm the most popular!");
        c4.send("I support Mac ;)");
        c5.send("whatever...");
        
    }
    
}
