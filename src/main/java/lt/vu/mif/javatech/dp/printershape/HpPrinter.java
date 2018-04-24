package lt.vu.mif.javatech.dp.printershape;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class HpPrinter implements Printer {

    @Override
    public void print(Shape s) {
        System.out.format("HP prints %s%n", s);
    }

}
