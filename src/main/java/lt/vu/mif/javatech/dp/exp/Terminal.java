package lt.vu.mif.javatech.dp.exp;

public class Terminal implements Expression {

    private final String data;

    public Terminal(String data) {
        this.data = data;
    }
    
    @Override
    public boolean interpret(String context) {
        if (context.contains(data)) {
            return true;
        }
        return false;
    }

}
