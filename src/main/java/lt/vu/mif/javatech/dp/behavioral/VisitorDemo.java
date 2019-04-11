package lt.vu.mif.javatech.dp.behavioral;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

abstract class Element<T> {

    private final T value;

    public Element(T value) {
        this.value = value;
    }
    
    abstract void accept(Visitor v);

    public T getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Element<?> other = (Element<?>) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Element{" + "value=" + value + '}';
    }

}

class Word extends Element<String> {

    public Word(String value) {
        super(value);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}

class Number extends Element<Integer> {

    public Number(Integer value) {
        super(value);
    }

    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }

}

interface Visitor {

    void visit(Word n);

    void visit(Number n);

}

class CountVisitor implements Visitor {

    private int words = 0;
    private int numbers = 0;

    @Override
    public void visit(Word n) {
        words += 1;
    }

    @Override
    public void visit(Number n) {
        numbers += 1;
    }

    public int getWords() {
        return words;
    }

    public int getNumbers() {
        return numbers;
    }
    
}

class FrequencyVisitor implements Visitor {

    private final FrequencyMap<Word> words = new FrequencyMap<>();
    private final FrequencyMap<Number> numbers = new FrequencyMap<>();

    @Override
    public void visit(Word n) {
        words.put(n);
    }

    @Override
    public void visit(Number n) {
        numbers.put(n);
    }
    
    public <K> void sortAndPrint(FrequencyMap<K> map) {
        map.sort();
        for (K key: map.keySet()) {
            System.out.format("%s = %d%n", key, map.get(key));
        }
    }

    public FrequencyMap<Word> getWords() {
        return words;
    }

    public FrequencyMap<Number> getNumbers() {
        return numbers;
    }

}

class TextProcessor {

    private final String text;

    public TextProcessor(String text) {
        this.text = text;
    }

    public void process(Visitor visitor) {
        for (String token : text.split(" |\\.|,")) {
            if (!token.isEmpty()) {
                Element el;
                if (token.matches("^[0-9]+$")) {
                    el = new Number(Integer.parseInt(token));
                } else {
                    el = new Word(token);
                }
                el.accept(visitor);
            }
        }
    }

}

/**
 * VisitorDemo
 *
 * @author valdo
 */
public class VisitorDemo {

    public static void main(String[] args) {

        TextProcessor tp = new TextProcessor("Contrary to popular belief, "
                + "Lorem Ipsum is not simply random text. It has roots in a "
                + "piece of classical Latin literature from 45 BC, making "
                + "it over 2000 years old. Richard McClintock, a Latin professor "
                + "at Hampden-Sydney College in Virginia, looked up one of the "
                + "more obscure Latin words, consectetur, from a Lorem Ipsum passage, "
                + "and going through the cites of the word in classical literature, "
                + "discovered the undoubtable source. Lorem Ipsum comes from sections "
                + "1.10.32 and 1.10.33 of de Finibus Bonorum et Malorum The Extremes "
                + "of Good and Evil by Cicero, written in 45 BC. This book is a treatise "
                + "on the theory of ethics, very popular during the Renaissance. The first "
                + "line of Lorem Ipsum, Lorem ipsum dolor sit amet.., comes from a "
                + "line in section 1.10.32.");

        CountVisitor counter = new CountVisitor();
        tp.process(counter);

        System.out.format("words = %d, numbers = %d%n", counter.getWords(), counter.getNumbers());

        FrequencyVisitor freq = new FrequencyVisitor();
        tp.process(freq);
        
        freq.sortAndPrint(freq.getWords());
        freq.sortAndPrint(freq.getNumbers());
        
    }

}

class FrequencyMap<K> extends LinkedHashMap<K, Integer> {

    public void put(K key) {
        int num = 0;
        if (this.containsKey(key)) {
            num = this.get(key);
        }
        this.put(key, num + 1);
    }

    public void sort() {

        List<Map.Entry<K, Integer>> entries = new LinkedList<>(this.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<K, Integer>>() {
            @Override
            public int compare(Map.Entry<K, Integer> o1, Map.Entry<K, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        this.clear();

        for (Map.Entry<K, Integer> e : entries) {
            put(e.getKey(), e.getValue());
        }

    }

}
