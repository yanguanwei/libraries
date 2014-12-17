package young.algorithm.sort;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-30
 */
public class MergeSort {
    public static void sort(int[] array) {
        int n = array.length;
        int[] temp = new int[n];
        sort(array, 0, n-1, temp);
    }

    /**
     * 递归分解数组成两半部分进行排序，然后合并这两个有序的数组
     *
     * @param array 数组
     * @param first 起始位置
     * @param last 末尾位置
     * @param temp 临时数组
     */
    private static void sort(int[] array, int first, int last, int[] temp) {
        if (first < last) {
            int middle = (first + last) / 2;
            sort(array, first, middle, temp);
            sort(array, middle+1, last, temp);
            merge(array, first, middle, last, temp);
        }
    }

    /**
     * 合并两个有序（array[first...middle]和array[middle+1...last]）的数组。
     * 先合并到temp数组中，再复制到array中
     *
     * @param array 源数组
     * @param first 源数组的起始位置
     * @param middle 源数组的中间位置
     * @param last 源数组的末尾位置
     * @param temp 临时数组
     */
    private static void merge(int[] array, int first, int middle, int last, int[] temp) {
        int i=first, j=middle+1, k = 0;
        while (i<=middle && j<=last) {
            if (array[i] < array[j]) {
                temp[k++] = array[i++];
            } else {
                temp[k++] = array[j++];
            }
        }

        while (i<=middle) {
            temp[k++] = array[i++];
        }

        while (j<=last) {
            temp[k++] = array[j++];
        }

        for (i=0; i<k; i++) {
            array[first+i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {3, 5, 2, 7, 4, 8, 9};
        sort(array);
        for (int d : array) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
}
