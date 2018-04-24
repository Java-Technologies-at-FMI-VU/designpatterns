package lt.vu.mif.javatech.dp.structural;

import lt.vu.mif.javatech.dp.printer.GenericPrinter;
import lt.vu.mif.javatech.dp.printer.Printer;
import lt.vu.mif.javatech.dp.shape.Circle;
import lt.vu.mif.javatech.dp.shape.Shape;
import lt.vu.mif.javatech.dp.shape.Square;

public class ProxyDemo {

    private static class PrinterProxy implements Printer {

        private static final String NAME = "my only printer";
        private Printer p;

        @Override
        public String getName() {
            return NAME;
        }

        @Override
        public void print(Shape s) {
            if (p == null) {
                p = new GenericPrinter(NAME);
            }
            p.print(s);
        }

    }

    public static void main(String[] args) {

        Printer p = new PrinterProxy();

        p.print(new Circle());
        p.print(new Square());

    }

}
