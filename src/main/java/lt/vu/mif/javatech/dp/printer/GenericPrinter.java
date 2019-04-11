package lt.vu.mif.javatech.dp.printer;

import lt.vu.mif.javatech.dp.shape.Shape;

public class GenericPrinter implements Printer {

    private final String name;

    public GenericPrinter(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
    
    @Override
    public void print(Shape s) {
        System.out.format("%s prints %s%n", this, s);
    }

    @Override
    public String toString() {
        return "GenericPrinter{" + "name=" + name + '}';
    }
    
}
