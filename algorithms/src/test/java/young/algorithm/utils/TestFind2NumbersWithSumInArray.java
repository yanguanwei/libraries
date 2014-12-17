package young.algorithm.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-30
 */
public class TestFind2NumbersWithSumInArray {

    @Test
    public void testFind() {
        int[] array = new int[] {1, 2, 4, 7, 11, 15};
        int[] result = Find2NumbersWithSumInArray.find(array, 15);
        Assert.assertEquals(15, result[0]+result[1]);
    }

    @Test
    public void testFindNull() {
        int[] array = new int[] {1, 2, 4, 7, 11, 15};
        int[] result = Find2NumbersWithSumInArray.find(array, 150);
        Assert.assertEquals(null, result);
    }
}
