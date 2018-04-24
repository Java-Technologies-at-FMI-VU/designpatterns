package lt.vu.mif.javatech.dp.structural;

import lt.vu.mif.javatech.dp.printer.GenericPrinter;
import lt.vu.mif.javatech.dp.printer.LegacyPrinter;
import lt.vu.mif.javatech.dp.shape.Circle;
import lt.vu.mif.javatech.dp.shape.Rectangle;
import lt.vu.mif.javatech.dp.shape.Shape;

interface PrinterAdapter {
    
    public void print(Shape shape);
    
}

class HPAdapter implements PrinterAdapter {

    private final GenericPrinter p = new GenericPrinter("HP");

    @Override
    public void print(Shape shape) {
        p.print(shape);
    }
    
}

class LexmarkAdapter implements PrinterAdapter {

    private final LegacyPrinter p = new LegacyPrinter("Lexmark", "some param");
    
    @Override
    public void print(Shape shape) {
        p.grabPaper();
        p.print(shape);
    }
    
}

public class AdapterDemo {

    private static void printShapes(Shape[] shapes, PrinterAdapter pa) {
        for (Shape s : shapes) {
            pa.print(s);
        }
    }

    public static void main(String[] args) {
        Shape[] shapes = new Shape[]{ new Circle(), new Circle(), new Rectangle() };

        printShapes(shapes, new HPAdapter());
        printShapes(shapes, new LexmarkAdapter());

    }

}
