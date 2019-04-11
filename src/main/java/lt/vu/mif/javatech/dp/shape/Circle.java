package lt.vu.mif.javatech.dp.shape;

public class Circle implements Shape {

    private final ShapeType type = ShapeType.CIRCLE;

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }

    @Override
    public ShapeType getType() {
        return type;
    }
    
    @Override
    public Circle clone() {
        try {
            return (Circle) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Exception occured: " + e.getMessage());
            return null;
        }
    }

}
