package lt.vu.mif.javatech.dp.creational;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lt.vu.mif.javatech.dp.shape.Circle;
import lt.vu.mif.javatech.dp.shape.Shape;
import lt.vu.mif.javatech.dp.shape.Square;

@AllArgsConstructor
class Creator {
    
    @Setter
    private Shape proto;
    
    public Shape create() {
        return proto.clone();
    }
    
}

public class PrototypeDemo {
   
    public static void main(String[] args) throws CloneNotSupportedException {

        Creator c = new Creator(new Circle());

        c.create().draw();
        c.create().draw();

        c.setProto(new Square());
        
        c.create().draw();
        c.create().draw();

    }

}
