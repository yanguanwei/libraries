package young.algorithm.sort;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-28
 */
public class HeapSort {

    public static void sort(int[] arr) {
        int n = arr.length-1;

        //建立大顶推，arr[1]保存的是最大值
        for (int i=n/2; i>=1; i--) {
            heapAdjust(arr, i, n);
        }

        for (int i=n; i>=1; i--) {
            int max = arr[1];
            arr[1] = arr[i];
            arr[i] = max;
            //arr[1..i-1]调整为大顶堆
            heapAdjust(arr, 1, i-1);
        }
    }

    public static void heapAdjust(int[] arr, int start, int end) {
        int max = arr[start];
        for (int i=2*start; i<=end; i*=2) {
            if (i<end && arr[i+1] > arr[i]) {
                i++;
            }
            if (arr[i] > max) {
                arr[start] = arr[i];
                start = i;
            } else {
                break;
            }
        }
        arr[start] = max;
    }

    public static void main(String[] args) {
        int arr[] = {0, 6, 3, 1, 8, 9, 4, 5};
        sort(arr);
        for (int i=1, n=arr.length; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
