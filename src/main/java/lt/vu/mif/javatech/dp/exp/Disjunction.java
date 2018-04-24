package lt.vu.mif.javatech.dp.exp;

public class Disjunction implements Expression {

    private final Expression[] exps;

    public Disjunction(Expression... exps) {
        this.exps = exps;
    }

    @Override
    public boolean interpret(String context) {

        for (Expression exp : exps) {
            if (exp.interpret(context)) {
                return true;
            }
        }

        return false;
    }

}
