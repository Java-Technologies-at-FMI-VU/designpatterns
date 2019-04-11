package lt.vu.mif.javatech.dp.printershape;

public class Rectangle extends Shape {

    private final int width;
    private final int height;

    public Rectangle(Printer p, int width, int height) {
        super(p);
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "width=" + width + ", height=" + height + '}';
    }
    
}
