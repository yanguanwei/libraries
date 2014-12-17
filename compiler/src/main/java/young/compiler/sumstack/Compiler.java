package young.compiler.sumstack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author young.alway@gmail.com
 * @since 2014-12-04
 */
public class Compiler {
    public List<StackType> stackTypes = new ArrayList<StackType>();

    public void compile(Expression expression) {
        if (null == expression) {
            return;
        }

        if (expression instanceof IntExpression) {
            stackTypes.add(new PushStackType(((IntExpression) expression).getValue()));
        } else if (expression instanceof SumExpression) {
            SumExpression sumExpression = (SumExpression) expression;
            compile(sumExpression.getLeft());
            compile(sumExpression.getRight());
            stackTypes.add(new AddStackType());
        }
    }

    public String generateCompiledCodes() {
        StringBuilder sb = new StringBuilder();

        for (StackType stackType : stackTypes) {
            if (stackType instanceof PushStackType) {
                sb.append("push ").append(((PushStackType) stackType).getValue()).append("\n");
            } else if (stackType instanceof AddStackType) {
                sb.append("add\n");
            }
        }

        return sb.toString();
    }

    public static void dumpExpression(Expression expression) {
        if (null == expression) {
            return ;
        }

        if (expression instanceof IntExpression) {
            System.out.print(((IntExpression) expression).getValue());
        } else if (expression instanceof SumExpression) {
            SumExpression sumExpression = (SumExpression) expression;
            dumpExpression(sumExpression.getLeft());
            System.out.print("+");
            dumpExpression(sumExpression.getRight());
        }
    }

    public static void main(String[] args) {
        Expression expression = new SumExpression(
                new SumExpression(
                        new IntExpression(2),
                        new IntExpression(3)
                ),
                new IntExpression(4)
        );

        dumpExpression(expression);
        System.out.println("");

        Compiler compiler = new Compiler();
        compiler.compile(expression);

        System.out.println(compiler.generateCompiledCodes());
    }
}
