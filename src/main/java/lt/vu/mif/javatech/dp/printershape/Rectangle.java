package lt.vu.mif.javatech.dp.printershape;

import lombok.ToString;

@ToString
public class Rectangle extends Shape {

    private final int width;
    private final int height;

    public Rectangle(Printer p, int width, int height) {
        super(p);
        this.width = width;
        this.height = height;
    }

}
