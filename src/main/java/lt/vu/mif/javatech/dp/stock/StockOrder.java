package lt.vu.mif.javatech.dp.stock;

public abstract class StockOrder implements Order {

    protected final Stock stock;

    public StockOrder(Stock stock) {
        this.stock = stock;
    }
    
}
