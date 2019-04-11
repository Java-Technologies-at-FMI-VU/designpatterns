package lt.vu.mif.javatech.dp.behavioral;

import java.math.BigDecimal;
import java.math.BigInteger;

interface Payment {
    void pay(BigDecimal ammount);
}

class CreditCardPayment implements Payment {

    private final BigInteger number;
    private final String name;
    private final String expYearMonth;

    public CreditCardPayment(BigInteger number, String name, String expYearMonth) {
        this.number = number;
        this.name = name;
        this.expYearMonth = expYearMonth;
    }
    
    @Override
    public void pay(BigDecimal ammount) {
        System.out.format("%s to be payed with credit card: %s, %s, %s%n", ammount, number, name, expYearMonth);
    }
    
}

class PayPalPayment implements Payment {

    private final String username;
    private final String password;

    public PayPalPayment(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    @Override
    public void pay(BigDecimal ammount) {
        System.out.format("%s to be payed with paypal: %s, ****%n", ammount, username, password);
    }
    
}

class ShoppingCart {
    
    private BigDecimal total = BigDecimal.ZERO;
    
    public void addItem(BigDecimal price, int count) {
        total = total.add(price.multiply(new BigDecimal(count)));
    }
    
    public void processPayment(Payment p) {
        p.pay(total);
    }
    
}

/**
 * StrategyDemo
 * @author valdo
 */
public class StrategyDemo {

    public static void main(String[] args) {
        
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(BigDecimal.ONE, 10);
        cart.addItem(BigDecimal.TEN, 8);
        
        Payment ccard = new CreditCardPayment(new BigInteger("1234567890"), "Some name", "2011-01");
        cart.processPayment(ccard);
        
        Payment paypal = new PayPalPayment("Some name", "secret");
        cart.processPayment(paypal);

    }
    
}
