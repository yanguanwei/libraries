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
     * 从arr数组中取出前n小的数组
     *
     * @param arr 大数组
     * @param n 前n小
     * @return 返回前n小的数组
     */
    public static Integer[] resolve(int[] arr, int n) {
        int len = arr.length;
        //利用堆排序或红黑树来存储前n个值
        SortedSet<Integer> set = new TreeSet<Integer>();

        for (int i=0; i<len; i++) {
            int d = arr[i];
            if (set.size()<n) { //直到存满n个值为止
                set.add(d);
            } else { //从这n个数中找出最大值
                int max = set.last();
                if (d < max) { //如果当前值比最大值小，说明这个值有可能是前n小里的
                    set.remove(max);
                    set.add(d);
                } //否则，丢弃该值
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
