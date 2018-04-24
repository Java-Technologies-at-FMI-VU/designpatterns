package lt.vu.mif.javatech.dp.printershape;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Shape {

    private final Printer p;

    public void print() {
        p.print(this);
    }

}
