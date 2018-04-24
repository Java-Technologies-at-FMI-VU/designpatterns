package lt.vu.mif.javatech.dp.behavioral;

interface Iterator<T> {
    
    boolean hasNext();
    T next();
    
}

interface Aggregator<T> {
    
    Iterator<T> iterator();
    
}

class GenericAggregator<T> implements Aggregator<T> {

    private final T[] values;
    
    public GenericAggregator(T... values) {
        this.values = values;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            
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

public class IteratorDemo {

    public static void main(String[] args) {
    
        GenericAggregator a1 = new GenericAggregator(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Iterator<Integer> it = a1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        
    }
    
}
