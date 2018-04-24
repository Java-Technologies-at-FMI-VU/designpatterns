package lt.vu.mif.javatech.dp.exp;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Terminal implements Expression {

    private final String data;

    @Override
    public boolean interpret(String context) {
        if (context.contains(data)) {
            return true;
        }
        return false;
    }

}
