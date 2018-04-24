package lt.vu.mif.javatech.dp.file;

public class File extends Node {

    private final String contents;

    public File(String name, String content) {
        super(name);
        this.contents = content;
    }

    @Override
    public void print() {
        System.out.println(getName() + ": " + contents);
    }

}
