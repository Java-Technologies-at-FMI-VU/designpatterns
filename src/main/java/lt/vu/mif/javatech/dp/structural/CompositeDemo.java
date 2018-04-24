package lt.vu.mif.javatech.dp.structural;

import lt.vu.mif.javatech.dp.file.File;
import lt.vu.mif.javatech.dp.file.Folder;

public class CompositeDemo {

    public static void main(String[] args) {

        Folder root = new Folder("");
        root.add(new File("service.log", "log content"));

        Folder etc = new Folder("myfolder");
        root.add(etc);

        etc.add(new File("another.txt", "This is some text"));
        etc.add(new File("some.conf", "#conf"));

        root.print();

    }

}
