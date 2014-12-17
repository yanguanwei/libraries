package young.algorithm.utils;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-30
 */
public class CountKInSortedArray {
    /**
     * 在有序的数组array中统计k出现的次数，
     * 通过二分查找k第一次出现的位置和最后一次出现的位置，来统计其出现的次数
     */
    public static int count(int[] array, int k) {
        int n = array.length;
        int first = find(array, 0, n-1, k, true);
        if (first == -1) {
            return 0;
        }

        if (first < n-1 && array[first+1] == k) {
            int last = find(array, 0, n-1, k, false);
            return last - first + 1;
        }

        return 1;
    }

    private static int find(int[] array, int first, int last, int k, boolean isFirst) {
        if (first > last) {
            return -1;
        }

        int middle = (first + last) / 2;
        if (array[middle] > k) {
            return find(array, first, middle-1, k, isFirst);
        } else if (array[middle] < k) {
            return find(array, middle+1, last, k, isFirst);
        } else {
            if (isFirst) {
                //如果middle不是第一个，并且它的前面一个还是k，继续寻找
                if (middle > first && array[middle-1] == k) {
                    return find(array, first, middle-1, k, true);
                }//否则，即middle是第一个元素了或是middle前一个不是k了
            } else {
                if (middle < last && array[middle+1] == k) {
                    return find(array, middle+1, last, k, false);
                }
            }

            return middle;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5, 5, 6, 7};
        System.out.println("4 occurs " + count(array, 4));
        System.out.println("5 occurs " + count(array, 5));
        System.out.println("1 occurs " + count(array, 1));
        System.out.println("7 occurs " + count(array, 7));
        System.out.println("8 occurs " + count(array, 8));
    }
}
