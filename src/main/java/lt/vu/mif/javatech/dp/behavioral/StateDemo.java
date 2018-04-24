package lt.vu.mif.javatech.dp.behavioral;

import lombok.Setter;

interface State {
    
    void doAction();
    
}

class OnState implements State {

    @Override
    public void doAction() {
        System.out.println("Running");
    }
    
}

class OffState implements State {

    @Override
    public void doAction() {
        System.out.println("Idle");
    }
    
}

class WashingMachine implements State {

    @Setter
    private State state;
    
    public WashingMachine(State state) {
        this.state = state;
    }
    
    @Override
    public void doAction() {
        state.doAction();
    }
    
}

/**
 * StateDemo
 * @author valdo
 */
public class StateDemo {

    public static void main(String[] args) {
        State on = new OnState();
        State off = new OffState();
        
        WashingMachine wm = new WashingMachine(off);
        wm.doAction();
        
        wm.setState(on);
        wm.doAction();
        
    }
    
}
