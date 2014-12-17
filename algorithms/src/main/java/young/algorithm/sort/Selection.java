package young.algorithm.sort;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-20
 */
public class Selection {
    public static void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i=0; i<n; i++) {
            int min = i;
            for (int j=i+1; j<n; j++) {
                if (SortUtils.less(arr[j], arr[min])) {
                    min = j;
                }
            }
            SortUtils.exchange(arr, min, i);
        }
    }
}
