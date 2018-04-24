package lt.vu.mif.javatech.dp.structural;

import lt.vu.mif.javatech.dp.printershape.Circle;
import lt.vu.mif.javatech.dp.printershape.EpsonPrinter;
import lt.vu.mif.javatech.dp.printershape.HpPrinter;
import lt.vu.mif.javatech.dp.printershape.Printer;
import lt.vu.mif.javatech.dp.printershape.Rectangle;
import lt.vu.mif.javatech.dp.printershape.Shape;

public class BridgeDemo {

    public static void main(String[] args) {

        Printer p1 = new HpPrinter();

        {
            Shape s = new Circle(p1, 10);
            s.print();
        }
        {
            Shape s = new Rectangle(p1, 10, 20);
            s.print();
        }

        Printer p2 = new EpsonPrinter();

        {
            Shape s = new Circle(p2, 20);
            s.print();
        }
        {
            Shape s = new Rectangle(p2, 12, 22);
            s.print();
        }

    }

}
