package lt.vu.mif.javatech.dp.stock;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class StockOrder implements Order {

    protected final Stock stock;

}
