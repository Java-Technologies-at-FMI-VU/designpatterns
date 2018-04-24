package lt.vu.mif.javatech.dp.behavioral;

class JavaCollection<T> implements Iterable<T> {

    private final T[] values;
    
    public JavaCollection(T... values) {
        this.values = values;
    }
    
    @Override
    public java.util.Iterator<T> iterator() {
        return new java.util.Iterator<T>() {
            
            private int i = 0;
            
            @Override
            public boolean hasNext() {
                return i < values.length;
            }

            @Override
            public T next() {
                return values[i++];
            }
        };
    }

}

public class IteratorJavaDemo {

    public static void main(String[] args) {
    
        JavaCollection<Integer> a1 = new JavaCollection<>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (Integer i: a1) {
            System.out.println(i);
        }
        
    }
    
}
