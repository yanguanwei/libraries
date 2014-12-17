package young.algorithm.utils;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-30
 */
public class CountArrayInversePair {

    /**
     * 统计数组中逆序数对的个数，
     * 把数组分解为两个有序的数组，则逆序数对个数的问题变为第二个数组对于第一个数组的逆数对个数的问题
     *
     * @param array 数组
     * @return 逆序数对的个数
     */
    public static int count(int[] array) {
        int n = array.length;
        int[] temp = new int[n];

        return sortAndCount(array, 0, n-1, temp);
    }

    /**
     * 利用归并排序，在合并两个有序数组时，统计第二个数组小于第一个数组的逆序对数
     */
    private static int sortAndCount(int[] array, int first, int last, int[] temp) {
        if (first < last) {
            int middle = (first + last) / 2;
            int count = 0;

            count += sortAndCount(array, first, middle, temp);
            count += sortAndCount(array, middle+1, last, temp);
            count += mergeAndCount(array, first, middle, last, temp);

            return count;
        }

        return 0;
    }

    private static int mergeAndCount(int[] array, int first, int middle, int last, int[] temp) {
        int count = 0, i=middle, j=last, n=last-first, m=middle+1, k=n;

        //从这两个有序数组的末尾开始扫描
        while (i>=first && j>=m) {
            //如果第一个数组的值大于第二个数组，则统计第二个数组当前位置到第一个位置的个数
            if (array[i] > array[j]) {
                temp[k--] = array[i--];
                count += j-m+1;
            } else {
                temp[k--] = array[j--];
            }
        }

        while (i>=first) {
            temp[k--] = array[i--];
        }

        while (j>=m) {
            temp[k--] = array[j--];
        }

        for (i=0; i<=n; i++) {
            array[first+i] = temp[i];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] array = new int[] {7, 5, 6, 4, 1};
        int count = count(array);

        System.out.println("count: " + count);
    }
}
