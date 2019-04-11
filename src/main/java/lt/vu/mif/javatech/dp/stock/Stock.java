package lt.vu.mif.javatech.dp.stock;

public class Stock {

    private final String name;
    private final int quantity;

    public Stock(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Stock{" + "name=" + name + ", quantity=" + quantity + '}';
    }
    
}
