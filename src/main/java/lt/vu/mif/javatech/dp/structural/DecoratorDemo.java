package lt.vu.mif.javatech.dp.structural;

import lt.vu.mif.javatech.dp.shape.Circle;
import lt.vu.mif.javatech.dp.shape.Shape;
import lt.vu.mif.javatech.dp.shape.ShapeType;

public class DecoratorDemo {

    private static class RedShape implements Shape {

        private final Shape shape;

        public RedShape(Shape shape) {
            this.shape = shape;
        }
        
        @Override
        public ShapeType getType() {
            return shape.getType();
        }

        @Override
        public void draw() {
            shape.draw();
            System.out.println("... in red!");
        }

        @Override
        public Shape clone() {
            try {
                return (Shape) super.clone();
            } catch (CloneNotSupportedException e) {
                System.out.println("Exception occured: " + e.getMessage());
                return null;
            }
        }

    }

    private static void drawShape(Shape s) {
        s.draw();
    }

    public static void main(String[] args) {

        Shape c = new Circle();
        drawShape(c);

        Shape d = new RedShape(c);
        drawShape(d);

    }

}
