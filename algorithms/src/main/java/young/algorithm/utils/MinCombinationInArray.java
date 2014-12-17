package young.algorithm.utils;

import java.util.*;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-28
 */
public class MinCombinationInArray {
    private static final Comparator<Integer> compare = new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            StringBuilder sb1 = new StringBuilder();
            sb1.append(o1).append(o2);

            StringBuilder sb2 = new StringBuilder();
            sb2.append(o2).append(o1);

            return  (int) (Long.valueOf(sb1.toString()) - Long.valueOf(sb2.toString()));
        }
    };

    public static long resolve(Integer[] array) {
        List<Integer> list = Arrays.asList(array);
        Collections.sort(list, compare);
        StringBuilder sb = new StringBuilder();
        for (Integer d : list) {
            sb.append(d);
        }
        return Long.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(resolve(new Integer[] {1, 23, 5}));
    }
}
