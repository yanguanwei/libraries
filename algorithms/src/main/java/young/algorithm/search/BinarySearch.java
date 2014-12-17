package young.algorithm.search;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-30
 */
public class BinarySearch {

    /**
     * ¶ş·Ö²éÕÒ
     */
    public static int search(int[] array, int k) {
        return search(array, 0, array.length-1, k);
    }

    public static int search(int[] array, int first, int last, int k) {
        if (first > last) {
            return -1;
        }

        int middle = (first + last) / 2;
        if (array[middle] > k) {
            return search(array, first, middle-1, k);
        } else if (array[middle] < k) {
            return search(array, middle+1, last, k);
        } else {
            return middle;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {2, 4, 6, 7, 8, 9};
        System.out.println("Index of 8: " + search(array, 8));
        System.out.println("Index of 10: " + search(array, 10));
    }
}
