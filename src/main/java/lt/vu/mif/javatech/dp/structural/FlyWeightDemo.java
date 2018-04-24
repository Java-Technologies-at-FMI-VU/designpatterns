package lt.vu.mif.javatech.dp.structural;

import java.util.EnumMap;
import java.util.Random;

import lt.vu.mif.javatech.dp.shape.Circle;
import lt.vu.mif.javatech.dp.shape.Rectangle;
import lt.vu.mif.javatech.dp.shape.Shape;
import lt.vu.mif.javatech.dp.shape.ShapeType;
import lt.vu.mif.javatech.dp.shape.Square;

public class FlyWeightDemo {

    private static class ShapeFactory {

        private final EnumMap<ShapeType, Shape> cache = new EnumMap<>(ShapeType.class);

        public Shape create(ShapeType type) {
            if (!cache.containsKey(type)) {
                switch (type) {
                    case CIRCLE:
                        cache.put(type, new Circle());
                        break;
                    case RECTANGLE:
                        cache.put(type, new Rectangle());
                        break;
                    case SQUARE:
                        cache.put(type, new Square());
                        break;
                }
            }
            return cache.get(type);
        }

    }

    public static void main(String[] args) {
        ShapeFactory f = new ShapeFactory();
        for (int i = 0; i < 1000; i++) {
            Shape s = f.create(randomEnum(ShapeType.class));
            s.draw();
        }
    }

    public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        int x = new Random().nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
    
}
