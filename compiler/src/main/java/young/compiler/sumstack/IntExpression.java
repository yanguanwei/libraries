package young.compiler.sumstack;

/**
 * @author young.alway@gmail.com
 * @since 2014-12-04
 */
public class IntExpression implements Expression {
    private int value;

    public IntExpression(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
