package lt.vu.mif.javatech.dp.stock;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StockExchange {

    private final String name;
    
    public enum OperationType {
        BUY, SELL
    }
    
    public void operation(OperationType otype, Stock stock) {
        
        System.out.format("%s: about to %s %s%n", name, otype.name(), stock);
        
    }
    
}
