package lt.vu.mif.javatech.dp.structural;

import java.util.Random;

import lt.vu.mif.javatech.dp.printershape.Circle;
import lt.vu.mif.javatech.dp.printershape.HpPrinter;
import lt.vu.mif.javatech.dp.printershape.Printer;
import lt.vu.mif.javatech.dp.printershape.Shape;

public class FacadeDemo {

    private static class ShapeMaker {

        private final Shape[] shapes;

        public ShapeMaker(Printer p, int numOfShapes) {
            shapes = new Shape[numOfShapes];
            for (int i = 0; i < numOfShapes; i++) {
                shapes[i] = new Circle(p, new Random().nextInt());
            }
        }

        public void print() {
            for (Shape s : shapes) {
                s.print();
            }
        }

    }

    public static void main(String[] args) {

        ShapeMaker m = new ShapeMaker(new HpPrinter(), 10);
        m.print();

    }

}
