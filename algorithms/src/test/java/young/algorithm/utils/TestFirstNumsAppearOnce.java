package young.algorithm.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-30
 */
public class TestFirstNumsAppearOnce {

    @Test
    public void testFind() {
        int[] array = new int[] {2, 4, 3, 6, 3, 2, 5, 5};
        int[] once = FindNumsAppearOnce.find(array);
        int a, b;
        if (once[0] < once[1]) {
            a = once[0];
            b = once[1];
        } else {
            a = once[1];
            b = once[0];
        }

        Assert.assertArrayEquals(new int[] {4, 6}, new int[] {a, b});
    }
}
