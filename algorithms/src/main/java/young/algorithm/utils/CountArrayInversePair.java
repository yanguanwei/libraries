package young.algorithm.utils;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-30
 */
public class CountArrayInversePair {

    /**
     * ͳ���������������Եĸ�����
     * ������ֽ�Ϊ������������飬���������Ը����������Ϊ�ڶ���������ڵ�һ������������Ը���������
     *
     * @param array ����
     * @return �������Եĸ���
     */
    public static int count(int[] array) {
        int n = array.length;
        int[] temp = new int[n];

        return sortAndCount(array, 0, n-1, temp);
    }

    /**
     * ���ù鲢�����ںϲ�������������ʱ��ͳ�Ƶڶ�������С�ڵ�һ��������������
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

        //�����������������ĩβ��ʼɨ��
        while (i>=first && j>=m) {
            //�����һ�������ֵ���ڵڶ������飬��ͳ�Ƶڶ������鵱ǰλ�õ���һ��λ�õĸ���
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
