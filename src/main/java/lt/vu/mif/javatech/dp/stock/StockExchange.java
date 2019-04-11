package lt.vu.mif.javatech.dp.stock;

public class StockExchange {

    private final String name;
    
    public enum OperationType {
        BUY, SELL
    }

    public StockExchange(String name) {
        this.name = name;
    }
    
    public void operation(OperationType otype, Stock stock) {
        System.out.format("%s: about to %s %s%n", name, otype.name(), stock);
    }
    
}
