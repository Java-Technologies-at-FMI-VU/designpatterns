package lt.vu.mif.javatech.dp.exp;

public class Conjunction implements Expression {

    private final Expression[] exps;

    public Conjunction(Expression... exps) {
        this.exps = exps;
    }

    @Override
    public boolean interpret(String context) {
        if (exps.length == 0) {
            return false;
        }

        for (Expression exp : exps) {
            if (!exp.interpret(context)) {
                return false;
            }
        }

        return true;
    }

}
