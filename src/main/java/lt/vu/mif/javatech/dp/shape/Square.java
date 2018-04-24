package lt.vu.mif.javatech.dp.shape;

import lombok.Getter;

public class Square implements Shape {

    @Getter
    private final ShapeType type = ShapeType.SQUARE;

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
