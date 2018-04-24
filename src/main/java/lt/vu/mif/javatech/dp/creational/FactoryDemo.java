package lt.vu.mif.javatech.dp.creational;

import lt.vu.mif.javatech.dp.vehicle.Vehicle;
import lt.vu.mif.javatech.dp.shape.Circle;
import lt.vu.mif.javatech.dp.shape.Rectangle;
import lt.vu.mif.javatech.dp.shape.Square;

abstract class VehicleFactory {

    public abstract Vehicle create();
    
}

class BicycleFactory extends VehicleFactory {

    @Override
    public Vehicle create() {
        Vehicle vehicle = new Vehicle("Bicycle");
        vehicle.addShape(new Circle());
        vehicle.addShape(new Circle());
        vehicle.addShape(new Rectangle());
        return vehicle;
    }

}

class CarFactory extends VehicleFactory {
    
    @Override
    public Vehicle create() {
        Vehicle car = new Vehicle("Car");
        car.addShape(new Circle());
        car.addShape(new Circle());
        car.addShape(new Circle());
        car.addShape(new Circle());
        car.addShape(new Rectangle());
        car.addShape(new Rectangle());
        car.addShape(new Rectangle());
        car.addShape(new Rectangle());
        car.addShape(new Square());
        car.addShape(new Square());
        return car;
    }

}

public class FactoryDemo {

    private static void makeAndPrintVehicle(VehicleFactory factory) {
        Vehicle vehicle = factory.create();
        System.out.println(vehicle);
    }

    public static void main(String[] args) {
        makeAndPrintVehicle(new BicycleFactory());
        makeAndPrintVehicle(new CarFactory());
    }

}
