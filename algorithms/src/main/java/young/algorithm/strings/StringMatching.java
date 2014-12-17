package young.algorithm.strings;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-22
 */
public class StringMatching {

    private static boolean checkArguments(String str, String pattern) {
        if (null == str || null == pattern) {
            throw new NullPointerException();
        }

        return !str.isEmpty() && !pattern.isEmpty();
    }

    public static int bf(String str, String pattern) {
        if (!checkArguments(str, pattern)) {
            return -1;
        }

        int n1 = str.length();
        int n2 = pattern.length();
        int i = 0, j = 0;
        while (i<n1 && j<n2) {
            if (str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                //当不匹配时，回溯，i->当前这一轮比较开始处的下一个位置，j->从头开始
                i = i - j + 1;
                j = 0;
            }
        }

        if (j >= n2) {
            return i-n2;
        } else {
            return -1;
        }
    }

    /**
     * next[i]表示的是pattern[0..i-1]子串中最大前缀后缀长度
     *
     * @param pattern 模式字符串
     * @return next数组
     */
    private static int[] resolveNextArray(String pattern) {
        int n = pattern.length();
        int[] next = new int[n];

        int i=0;
        int j=-1;
        next[0] = -1;
        while (i<n-1) { //求next[i+1]，必须求出0..i子串的最大前缀后缀长度
            //j表示0..i-1子串的最大前缀后缀长度
            if (j<0 || pattern.charAt(j) == pattern.charAt(i)) {
                i++;
                j++;
                //避免重复匹配：在kmp匹配中，回溯的位置与当前不匹配的字符相同，不需要再比较，直接再回溯
                //例如pattern: abab，str: abacababc
                //abacababc
                //abab
                //当匹配到字符c与b时，不匹配，则再回溯到b（下标从3->1），再次进行c与b的比较
                if (pattern.charAt(i) == pattern.charAt(j)) {
                    next[i] = next[j];
                } else {
                    next[i] = j;
                }
            } else {
                j = next[j];
            }
        }

        return next;
    }

    /**
     *
     * <a href="http://blog.csdn.net/v_july_v/article/details/7041827">原理参考出处</a>
     *
     * @param str 主串
     * @param pattern 查找的子串
     * @return 子串在主串中的下标值，找不到返回-1
     */
    public static int kmp(String str, String pattern) {
        if (!checkArguments(str, pattern)) {
            return -1;
        }

        int n1 = str.length();
        int n2 = pattern.length();
        int i = 0, j = 0;
        int[] next = resolveNextArray(pattern);
        while (i<n1 && j<n2) {
            if (j < 0 || str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                //与bf算法相比不同的是，固定str中的i位置不变，回溯pattern中的j
                j = next[j];
            }
        }

        if (j >= n2) {
            return i-n2;
        } else {
            return -1;
        }
    }
}
