package lt.vu.mif.javatech.dp.file;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Node {

    private final List<Node> children = new ArrayList<>();

    public Folder(String name) {
        super(name);
    }

    public void add(Node node) {
        children.add(node);
    }

    public void remove(Node node) {
        children.remove(node);
    }

    public int size() {
        return children.size();
    }

    public Node getChild(int i) {
        return children.get(i);
    }

    @Override
    public void print() {
        System.out.println(getName() + "/");
        for (Node n : children) {
            n.print();
        }
    }

}
