package lt.vu.mif.javatech.dp;

interface ObjBuilder<T> {
    T build();
}

class Book {

    private final String author;
    private final String title;
    private final int year;

    private Book(Builder b) {
        this.author = b.author;
        this.title = b.title;
        this.year = b.year;
    }

    static class Builder implements ObjBuilder<Book> {

        private final String title;
        private String author = "unknown";
        private int year = Integer.MIN_VALUE;

        public Builder(String title) {
            this.title = title;
        }
        
        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder year(int year) {
            this.year = year;
            return this;
        }

        @Override
        public Book build() {
            return new Book(this);
        }
        
    }

    @Override
    public String toString() {
        return "Book{" + "author=" + author + ", title=" + title + ", year=" + year + '}';
    }
    
}

public class FlowBuilderDemo {

    public static void main(String[] args) {

        Book.Builder bb = new Book.Builder("The Adventures of Tom Sawyer");
        Book b1 = bb.author("Mark Twain").year(1876).build();

        System.out.println(b1);

        Book b2 = new Book.Builder("Wiped Out").year(1966).build();
        System.out.println(b2);

        Book b3 = new Book.Builder("Torah").build();
        System.out.println(b3);

    }

}
