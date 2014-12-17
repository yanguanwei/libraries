package young.algorithm.utils;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-30
 */
public class Find2NumbersWithSumInArray {

    /**
     * 在递增有序的数组array中，找出两个元素的和为sum，
     * 并返回这两个元素。
     *
     * 设定两个指针i, j分别指向数组的首和尾，相加i, j指向的数，
     * 大于sum，j向左移动，使和变小；
     * 大于sub，i向右移动，使和变大
     */
    public static int[] find(int[] array, int sum) {
        int i=0, j=array.length-1, s;
        while (i<j) {
            s = array[i] + array[j];
            if (s < sum) {
                i++;
            } else if (s > sum) {
                j--;
            } else {
                return new int[] {array[i], array[j]};
            }
        }

        return null;
    }
}
