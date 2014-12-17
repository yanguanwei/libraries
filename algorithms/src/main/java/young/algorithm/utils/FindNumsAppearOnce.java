package young.algorithm.utils;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-30
 */
public class FindNumsAppearOnce {

    /**
     * array数组中只有两个元素的值只出现一次，其他元素都出现两次；
     * 如果一个数组中只有一个元素的值只出现一次，其他元素都出现两次，则可以利用异或运算求这个只现出一次的值。
     * 把数组分成两个子数组，每个子数组满足上述情况
     */
    public static int[] find(int[] array) {
        int xor = 0;

        for (int d : array) {
            xor ^= d;
        }
        //此时xor的值是数组中两个只出现一次的两个值的异或，并且这个值一定不为0
        //找出第一个1出现的位置
        int i = findFirstBitIs1(xor);

        //根据i位置为1的条件，把数组分成两个子数组
        //肯定可以把那两个只出现一次的元素划分到不同的子数组中
        //并且元素相同的只会划分到同一个子数组中
        int a = 0, b = 0;
        for (int d : array) {
            if (isBit1(d, i)) {
                a ^= d;
            } else {
                b ^= d;
            }
        }

        return new int[] {a, b};
    }

    private static int findFirstBitIs1(int d) {
        int i = 0;
        while ((d & 1) == 0 && i < 32) {
            d = d >>> 1;
            i++;
        }

        return i;
    }

    private static boolean isBit1(int d, int i) {
        d = d >>> i;
        return (d & 1) == 1;
    }
}
