package young.algorithm.utils;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-30
 */
public class CountKInSortedArray {
    /**
     * �����������array��ͳ��k���ֵĴ�����
     * ͨ�����ֲ���k��һ�γ��ֵ�λ�ú����һ�γ��ֵ�λ�ã���ͳ������ֵĴ���
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
                //���middle���ǵ�һ������������ǰ��һ������k������Ѱ��
                if (middle > first && array[middle-1] == k) {
                    return find(array, first, middle-1, k, true);
                }//���򣬼�middle�ǵ�һ��Ԫ���˻���middleǰһ������k��
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
