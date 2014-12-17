package young.algorithm.data;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-30
 */
public class MutableInteger {
    private int value;

    public MutableInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
