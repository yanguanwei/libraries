package young.algorithm.strings;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-28
 */
public class Permutation {

    public static void resolve(String str) {
        resolve(str.toCharArray(), 0);
    }

    private static void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    public static void resolve(char[] chars, int cur) {
        int len = chars.length;
        if (cur >= len) {
            System.out.println(new String(chars));
        } else {
            for (int i=cur; i<len; i++) {
                swap(chars, cur, i);
                resolve(chars, cur+1);
                swap(chars, cur, i);
            }
        }
    }

    public static void main(String[] args) {
        resolve("tao");
    }
}
