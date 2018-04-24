package lt.vu.mif.javatech.dp.printer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lt.vu.mif.javatech.dp.shape.Shape;

@ToString
@RequiredArgsConstructor
public class GenericPrinter implements Printer {

    @Getter
    private final String name;

    @Override
    public void print(Shape s) {
        System.out.format("%s prints %s%n", this, s);
    }

}
