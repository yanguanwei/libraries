package young.algorithm.sort;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-20
 */
public class Insertion {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i=1; i<n; i++) {
            for (int j=i; j>0 && SortUtils.less(arr[j], arr[j-1]); j--) {
                SortUtils.exchange(arr, j, j-1);
            }
        }
    }
}
