package young.algorithm.bigdata;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-28
 */
public class TopN {
    /**
     * ��arr������ȡ��ǰnС������
     *
     * @param arr ������
     * @param n ǰnС
     * @return ����ǰnС������
     */
    public static Integer[] resolve(int[] arr, int n) {
        int len = arr.length;
        //���ö�������������洢ǰn��ֵ
        SortedSet<Integer> set = new TreeSet<Integer>();

        for (int i=0; i<len; i++) {
            int d = arr[i];
            if (set.size()<n) { //ֱ������n��ֵΪֹ
                set.add(d);
            } else { //����n�������ҳ����ֵ
                int max = set.last();
                if (d < max) { //�����ǰֵ�����ֵС��˵�����ֵ�п�����ǰnС���
                    set.remove(max);
                    set.add(d);
                } //���򣬶�����ֵ
            }
        }

        return set.toArray(new Integer[] {0});
    }

    public static void main(String[] args) {
        int[] arr = new int[] {6, 4, 3, 2, 1, 8, 7, 9, 12, 43, 56, 32, 13, 89, 55, 34};
        Integer[] sorted = resolve(arr, 6);
        for (Integer d : sorted) {
            System.out.print(d + " ");
        }

        System.out.println();
    }
}
