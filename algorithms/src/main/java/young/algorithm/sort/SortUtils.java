package young.algorithm.sort;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-20
 */
public final class SortUtils {
    public static <T extends Comparable>boolean less(Comparable<T> a, T b) {
        return a.compareTo(b) < 0;
    }

    public static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
