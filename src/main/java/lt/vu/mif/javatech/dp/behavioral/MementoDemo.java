package lt.vu.mif.javatech.dp.behavioral;

class TextFile {

    private String title;
    private StringBuilder data = new StringBuilder();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public void add(String str) {
        this.data.append(str);
    }
    
    public String getData() {
        return this.data.toString();
    }
    
    public Memento save() {
        return new Memento(this);
    }
    
    public void undo(Object obj) {
        Memento m = (Memento) obj;
        this.title = m.title;
        this.data = new StringBuilder(m.data);
    }
    
    private class Memento {
        
        private final String title;
        private final StringBuilder data;
        
        public Memento(TextFile db) {
            this.title = db.title;
            this.data = new StringBuilder(db.data);
        }
        
    }

    @Override
    public String toString() {
        return "TextFile{" + "title=" + title + ", data=" + data + '}';
    }
    
}

class TextFileCareTaker {
    
    private Object saved;
    
    public void save(TextFile db) {
        this.saved = db.save();
    }
    
    public void undo(TextFile db) {
        db.undo(saved);
    }

}

/**
 * MementoDemo
 * @author valdo
 */
public class MementoDemo {

    public static void main(String[] args) {
        
        TextFile f = new TextFile();
        f.setTitle("data.txt");
        f.add("Some data");
        f.add(", some data again");
        System.out.println(f);
        
        TextFileCareTaker careTaker = new TextFileCareTaker();
        careTaker.save(f);
        
        f.setTitle("oh-my-god.exe");
        f.add(", again data");
        System.out.println(f);
        
        careTaker.undo(f);
        System.out.println(f);
        
    }
    
}
