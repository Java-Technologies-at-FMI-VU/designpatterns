package lt.vu.mif.javatech.dp.printershape;

public class Circle extends Shape {

    private final int radius;

    public Circle(Printer p, int radius) {
        super(p);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" + "radius=" + radius + '}';
    }
    
}
