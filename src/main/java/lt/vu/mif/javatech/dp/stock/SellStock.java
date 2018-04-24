package lt.vu.mif.javatech.dp.stock;

public class SellStock extends StockOrder {

    public SellStock(Stock stock) {
        super(stock);
    }

    @Override
    public void execute(StockExchange exchange) {
        exchange.operation(StockExchange.OperationType.SELL, stock);
    }

}
