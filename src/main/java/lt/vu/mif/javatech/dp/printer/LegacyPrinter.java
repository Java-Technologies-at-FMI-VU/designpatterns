package lt.vu.mif.javatech.dp.printer;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lt.vu.mif.javatech.dp.shape.Shape;

@ToString
@RequiredArgsConstructor
public class LegacyPrinter implements Printer {

    @Getter
    private final String name;
    private final String someInitializationParameter;

    public void grabPaper() {
        System.out.format("Grabbing paper in %s with %s%n", this, someInitializationParameter);
    }

    @Override
    public void print(Shape s) {
        System.out.format("%s prints %s%n", this, s);
    }

}
