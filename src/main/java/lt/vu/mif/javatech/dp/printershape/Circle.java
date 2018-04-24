package lt.vu.mif.javatech.dp.printershape;

import lombok.ToString;

@ToString
public class Circle extends Shape {

    private final int radius;

    public Circle(Printer p, int radius) {
        super(p);
        this.radius = radius;
    }

}
