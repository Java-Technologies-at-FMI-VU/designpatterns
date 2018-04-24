package lt.vu.mif.javatech.dp.shape;

import lombok.Getter;

public class Rectangle implements Shape {

    @Getter
    private final ShapeType type = ShapeType.RECTANGLE;

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
