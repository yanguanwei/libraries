package young.algorithm.sort;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-20
 */
public class TestSelection {
    Integer[] initArray() {
        return new Integer[] {3, 4, 2, 1, 5, 8, 7, 0, 9, 6};
    }

    Integer[] sortedArray() {
        return new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    @Test
    public void testSort() {
        Integer[] arr = initArray();
        Selection.sort(arr);
        Assert.assertArrayEquals(arr, sortedArray());
    }
}
