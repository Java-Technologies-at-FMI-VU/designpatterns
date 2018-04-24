package lt.vu.mif.javatech.dp.printer;

import lt.vu.mif.javatech.dp.shape.Shape;

public interface Printer {

    String getName();

    void print(Shape s);

}
