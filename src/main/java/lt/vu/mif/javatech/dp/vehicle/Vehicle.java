package lt.vu.mif.javatech.dp.vehicle;

import java.util.ArrayList;
import java.util.List;
import lt.vu.mif.javatech.dp.shape.Shape;
import lt.vu.mif.javatech.dp.shape.ShapeType;

public class Vehicle {

    private final String name;
    private final List<Shape> shapes = new ArrayList<>();

    public Vehicle(String name) {
        this.name = name;
    }
    
    public void addShape(Shape s) {
        shapes.add(s);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ShapeType st : ShapeType.values()) {
            int n = 0;
            for (Shape s : shapes) {
                if (s.getType().equals(st)) {
                    n++;
                }
            }
            sb.append(sb.length() > 0 ? ", " : "").append(n).append(" x ").append(st);
        }
        sb.insert(0, " (").insert(0, name).append(")");
        return sb.toString();
    }

}