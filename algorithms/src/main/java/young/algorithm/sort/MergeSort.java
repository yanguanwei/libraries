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
     * �ݹ�ֽ���������벿�ֽ�������Ȼ��ϲ����������������
     *
     * @param array ����
     * @param first ��ʼλ��
     * @param last ĩβλ��
     * @param temp ��ʱ����
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
     * �ϲ���������array[first...middle]��array[middle+1...last]�������顣
     * �Ⱥϲ���temp�����У��ٸ��Ƶ�array��
     *
     * @param array Դ����
     * @param first Դ�������ʼλ��
     * @param middle Դ������м�λ��
     * @param last Դ�����ĩβλ��
     * @param temp ��ʱ����
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
