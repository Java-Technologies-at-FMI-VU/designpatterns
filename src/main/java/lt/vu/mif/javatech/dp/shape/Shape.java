package lt.vu.mif.javatech.dp.shape;

public interface Shape extends Cloneable {

    ShapeType getType();
    void draw();
    
    public Shape clone();

}
