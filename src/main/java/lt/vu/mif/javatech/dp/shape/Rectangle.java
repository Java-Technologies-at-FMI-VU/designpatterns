package lt.vu.mif.javatech.dp.shape;

public class Rectangle implements Shape {

    private final ShapeType type = ShapeType.RECTANGLE;

    @Override
    public ShapeType getType() {
        return type;
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
    
    @Override
    public Rectangle clone() {
        try {
            return (Rectangle) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Exception occured: " + e.getMessage());
            return null;
        }
    }

}
