package young.compiler.sumstack;

/**
 * @author young.alway@gmail.com
 * @since 2014-12-04
 */
public class SumExpression implements Expression {
    private Expression left;
    private Expression right;

    public SumExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }
}
