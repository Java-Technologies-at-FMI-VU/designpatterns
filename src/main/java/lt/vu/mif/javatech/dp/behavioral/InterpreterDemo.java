package lt.vu.mif.javatech.dp.behavioral;

import lt.vu.mif.javatech.dp.exp.Conjunction;
import lt.vu.mif.javatech.dp.exp.Disjunction;
import lt.vu.mif.javatech.dp.exp.Expression;
import lt.vu.mif.javatech.dp.exp.Terminal;

public class InterpreterDemo {

    private static Expression getIsMale() {
        return new Disjunction(
                new Terminal("Jonas"),
                new Terminal("Petras"),
                new Terminal("Antanas")
        );
    }

    private static Expression getIsFemale() {
        return new Disjunction(
                new Terminal("Ona"),
                new Terminal("Ieva"),
                new Terminal("Laura")
        );
    }

    private static Expression getCanPlayMix() {
        return new Conjunction(
                getIsMale(),
                getIsFemale()
        );
    }

    public static void main(String[] args) {

        Expression isMale = getIsMale();
        Expression isFemale = getIsFemale();
        Expression canPlayMix = getCanPlayMix();

        System.out.format("Jonas is male? %s%n", isMale.interpret("Jonas"));
        System.out.format("Jonas is female? %s%n", isFemale.interpret("Jonas"));
        System.out.format("Ona is male? %s%n", isMale.interpret("Ona"));
        System.out.format("Ona is female? %s%n", isFemale.interpret("Ona"));

        System.out.format("Can play mix Jonas and Petras? %s%n", canPlayMix.interpret("Jonas ir Petras"));
        System.out.format("Can play mix Jonas and Ona? %s%n", canPlayMix.interpret("Jonas ir Ona"));

    }

}
