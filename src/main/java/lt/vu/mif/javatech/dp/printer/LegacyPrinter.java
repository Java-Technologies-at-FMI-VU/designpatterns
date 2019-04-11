package lt.vu.mif.javatech.dp.printer;

import lt.vu.mif.javatech.dp.shape.Shape;

public class LegacyPrinter implements Printer {

    private final String name;
    private final String someInitializationParameter;

    public LegacyPrinter(String name, String someInitializationParameter) {
        this.name = name;
        this.someInitializationParameter = someInitializationParameter;
    }
    
    public void grabPaper() {
        System.out.format("Grabbing paper in %s with %s%n", this, someInitializationParameter);
    }

    @Override
    public void print(Shape s) {
        System.out.format("%s prints %s%n", this, s);
    }

    public String getName() {
        return name;
    }

    public String getSomeInitializationParameter() {
        return someInitializationParameter;
    }

    @Override
    public String toString() {
        return "LegacyPrinter{" + "name=" + name + ", someInitializationParameter=" + someInitializationParameter + '}';
    }
    
}
