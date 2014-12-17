package young.compiler.sumstack;

/**
 * @author young.alway@gmail.com
 * @since 2014-12-04
 */
public class PushStackType implements StackType {
    private int value;

    public PushStackType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
