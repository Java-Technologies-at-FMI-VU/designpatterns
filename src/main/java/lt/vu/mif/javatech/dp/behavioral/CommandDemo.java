package lt.vu.mif.javatech.dp.behavioral;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;

import lt.vu.mif.javatech.dp.stock.BuyStock;
import lt.vu.mif.javatech.dp.stock.Order;
import lt.vu.mif.javatech.dp.stock.SellStock;
import lt.vu.mif.javatech.dp.stock.Stock;
import lt.vu.mif.javatech.dp.stock.StockExchange;

@RequiredArgsConstructor
class Broker {

    private final StockExchange exchange;
    private final List<Order> orders = new ArrayList<>();

    public void placeOrder(Order o) {
        orders.add(o);
    }

    public void executeOrders() {
        for (Order o : orders) {
            o.execute(this.exchange);
        }
    }

}

public class CommandDemo {

    public static void main(String[] args) {
        
        StockExchange exchange = new StockExchange("Nasdaq Vilnius");
        Broker b = new Broker(exchange);

        b.placeOrder(new BuyStock(new Stock("TEO1L", 1000)));
        b.placeOrder(new BuyStock(new Stock("LES1L", 5000)));
        b.placeOrder(new SellStock(new Stock("TEO1L", 1000)));

        b.executeOrders();

    }

}
