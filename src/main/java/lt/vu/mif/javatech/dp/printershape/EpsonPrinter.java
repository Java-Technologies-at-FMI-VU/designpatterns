package lt.vu.mif.javatech.dp.printershape;

public class EpsonPrinter implements Printer {

    @Override
    public void print(Shape s) {
        System.out.format("Epson prints %s%n", s);
    }

    @Override
    public String toString() {
        return "EpsonPrinter{" + '}';
    }
    
}
