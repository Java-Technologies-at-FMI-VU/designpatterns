package lt.vu.mif.javatech.dp.stock;

public class BuyStock extends StockOrder {

    public BuyStock(Stock stock) {
        super(stock);
    }

    @Override
    public void execute(StockExchange exchange) {
        exchange.operation(StockExchange.OperationType.BUY, stock);
    }

}
