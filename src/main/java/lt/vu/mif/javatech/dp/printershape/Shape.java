package lt.vu.mif.javatech.dp.printershape;

public abstract class Shape {

    private final Printer p;

    public Shape(Printer p) {
        this.p = p;
    }
    
    public void print() {
        p.print(this);
    }

}
