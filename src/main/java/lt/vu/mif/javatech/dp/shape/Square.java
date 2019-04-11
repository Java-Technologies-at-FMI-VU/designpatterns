package lt.vu.mif.javatech.dp.shape;

public class Square implements Shape {

    private final ShapeType type = ShapeType.SQUARE;

    @Override
    public ShapeType getType() {
        return type;
    }
    
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }

    @Override
    public Square clone() {
        try {
            return (Square) super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("Exception occured: " + e.getMessage());
            return null;
        }
    }
    
}
