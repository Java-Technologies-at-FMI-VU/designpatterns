package lt.vu.mif.javatech.dp.creational;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lt.vu.mif.javatech.dp.shape.Circle;
import lt.vu.mif.javatech.dp.shape.Rectangle;
import lt.vu.mif.javatech.dp.shape.Shape;
import lt.vu.mif.javatech.dp.shape.Square;

abstract class AbstractFactory {

    abstract Collection<Shape> getShapes();

}

class RoundShapeFactory extends AbstractFactory {

    @Override
    public Collection<Shape> getShapes() {

        return Collections.singletonList((Shape) new Circle());

    }
}

class RectangularShapeFactory extends AbstractFactory {

    @Override
    public Collection<Shape> getShapes() {
        
        List<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle());
        shapes.add(new Square());
        return shapes;
        
    }
}

public class AbstractFactoryDemo {

    private static void drawShapes(AbstractFactory f) {
        System.out.println(f);
        for (Shape s : f.getShapes()) {
            s.draw();
        }
    }

    public static void main(String[] args) {

        drawShapes(new RoundShapeFactory());
        drawShapes(new RectangularShapeFactory());

    }

}
