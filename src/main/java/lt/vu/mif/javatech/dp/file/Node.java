package lt.vu.mif.javatech.dp.file;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class Node {

    @Getter
    private final String name;

    public abstract void print();

}
