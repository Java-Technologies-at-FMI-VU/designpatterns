package lt.vu.mif.javatech.dp.printershape;


public class HpPrinter implements Printer {

    @Override
    public void print(Shape s) {
        System.out.format("HP prints %s%n", s);
    }

    @Override
    public String toString() {
        return "HpPrinter{" + '}';
    }
    
}
