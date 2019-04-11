package lt.vu.mif.javatech.dp.creational;

import lt.vu.mif.javatech.dp.shape.Circle;
import lt.vu.mif.javatech.dp.shape.Shape;
import lt.vu.mif.javatech.dp.shape.Square;

class Creator {
    
    private Shape proto;

    public Creator(Shape proto) {
        this.proto = proto;
    }
    
    public Shape create() {
        return proto.clone();
    }

    public void setProto(Shape proto) {
        this.proto = proto;
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
