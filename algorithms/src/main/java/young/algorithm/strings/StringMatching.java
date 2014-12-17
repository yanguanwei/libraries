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
                //����ƥ��ʱ�����ݣ�i->��ǰ��һ�ֱȽϿ�ʼ������һ��λ�ã�j->��ͷ��ʼ
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
     * next[i]��ʾ����pattern[0..i-1]�Ӵ������ǰ׺��׺����
     *
     * @param pattern ģʽ�ַ���
     * @return next����
     */
    private static int[] resolveNextArray(String pattern) {
        int n = pattern.length();
        int[] next = new int[n];

        int i=0;
        int j=-1;
        next[0] = -1;
        while (i<n-1) { //��next[i+1]���������0..i�Ӵ������ǰ׺��׺����
            //j��ʾ0..i-1�Ӵ������ǰ׺��׺����
            if (j<0 || pattern.charAt(j) == pattern.charAt(i)) {
                i++;
                j++;
                //�����ظ�ƥ�䣺��kmpƥ���У����ݵ�λ���뵱ǰ��ƥ����ַ���ͬ������Ҫ�ٱȽϣ�ֱ���ٻ���
                //����pattern: abab��str: abacababc
                //abacababc
                //abab
                //��ƥ�䵽�ַ�c��bʱ����ƥ�䣬���ٻ��ݵ�b���±��3->1�����ٴν���c��b�ıȽ�
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
     * <a href="http://blog.csdn.net/v_july_v/article/details/7041827">ԭ��ο�����</a>
     *
     * @param str ����
     * @param pattern ���ҵ��Ӵ�
     * @return �Ӵ��������е��±�ֵ���Ҳ�������-1
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
                //��bf�㷨��Ȳ�ͬ���ǣ��̶�str�е�iλ�ò��䣬����pattern�е�j
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
