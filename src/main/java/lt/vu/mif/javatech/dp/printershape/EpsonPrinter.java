package lt.vu.mif.javatech.dp.printershape;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public class EpsonPrinter implements Printer {

    @Override
    public void print(Shape s) {
        System.out.format("Epson prints %s%n", s);
    }

}
