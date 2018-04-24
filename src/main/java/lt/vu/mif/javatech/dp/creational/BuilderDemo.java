package lt.vu.mif.javatech.dp.creational;

import lt.vu.mif.javatech.dp.vehicle.Vehicle;
import lt.vu.mif.javatech.dp.shape.Circle;
import lt.vu.mif.javatech.dp.shape.Rectangle;
import lt.vu.mif.javatech.dp.shape.Square;

interface VehicleBuilder {
    
    public void addWheels();
    public void addFrame();
    public void addLamps();
    public Vehicle result();
    
}

class BicycleBuilder implements VehicleBuilder {

    private final Vehicle vehicle = new Vehicle("Bicycle");
    
    @Override
    public Vehicle result() {
        return this.vehicle;
    }

    @Override
    public void addWheels() {
        this.vehicle.addShape(new Circle());
        this.vehicle.addShape(new Circle());
    }

    @Override
    public void addFrame() {
        this.vehicle.addShape(new Rectangle());
    }

    @Override
    public void addLamps() {
        this.vehicle.addShape(new Circle());
    }

}

class CarBuilder implements VehicleBuilder {
    
    private final Vehicle vehicle = new Vehicle("Car");
    
    @Override
    public Vehicle result() {
        return this.vehicle;
    }

    @Override
    public void addWheels() {
        this.vehicle.addShape(new Circle());
        this.vehicle.addShape(new Circle());
        this.vehicle.addShape(new Circle());
        this.vehicle.addShape(new Circle());
    }

    @Override
    public void addFrame() {
        this.vehicle.addShape(new Rectangle());
        this.vehicle.addShape(new Rectangle());
        this.vehicle.addShape(new Rectangle());
        this.vehicle.addShape(new Rectangle());
        this.vehicle.addShape(new Square());
        this.vehicle.addShape(new Square());
    }

    @Override
    public void addLamps() {
        this.vehicle.addShape(new Circle());
        this.vehicle.addShape(new Circle());
    }
    
}

public class BuilderDemo {

    private static void buildAndPrintVehicle(VehicleBuilder builder) {
        builder.addWheels();
        builder.addFrame();
        Vehicle vehicle = builder.result();
        System.out.println(vehicle);
    }

    public static void main(String[] args) {
        buildAndPrintVehicle(new BicycleBuilder());
        buildAndPrintVehicle(new CarBuilder());
    }

}
