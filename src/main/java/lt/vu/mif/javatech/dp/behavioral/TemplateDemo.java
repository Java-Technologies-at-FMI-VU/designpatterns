package lt.vu.mif.javatech.dp.behavioral;

abstract class Summator {
    
    public int getSum() {
        int sum = 0;
        for (int i: readData()) {
            sum += i;
        }
        return sum;
    }

    public int getAvg() {
        return getSum() / readData().length;
    }
    
    protected abstract int[] readData();
    
}

class StringSummator extends Summator {

    private final String str;

    public StringSummator(String str) {
        this.str = str;
    }

    @Override
    protected int[] readData() {
        String[] elems = str.split(",");
        int[] data = new int[elems.length];
        for (int i = 0; i < elems.length; i++) {
            data[i] = Integer.parseInt(elems[i]);
        }
        return data;
    }
    
}

class IntSummator extends Summator {

    private final int[] data;

    public IntSummator(int... data) {
        this.data = data;
    }
    
    @Override
    protected int[] readData() {
        return data;
    }
    
}

/**
 * TemplateDemo
 * @author valdo
 */
public class TemplateDemo {

    public static void main(String[] args) {

        Summator[] summators = new Summator[] {
            new StringSummator("12,14,16,18,20"),
            new StringSummator("100,1,15,48,55,12,9,44"),
            new IntSummator(12, 14, 16, 18, 20),
            new IntSummator(100, 1, 15, 48, 55, 12, 9, 44)
        };
        
        for (Summator s: summators) {
            System.out.format("Summator: sum = %d, avg = %d%n", s.getSum(), s.getAvg());
        }
        
    }
    
}
