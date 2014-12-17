package young.algorithm.utils;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-30
 */
public class FindContinuousSequence {
    /**
     * ��ӡ�����к�Ϊsum���������У����ٰ���2����
     */
    public static void find(int sum) {
        if (sum<3) {
            return;
        }

        int i=1, j=2, s = i+j, m = (sum + 1)/2;
        while (i<m) {
            if (s==sum) {
                print(i, j);
            }

            while (s>sum && i<j) {
                s -= i;
                i++;

                if (s==sum) {
                    print(i, j);
                }
            }

            j++;
            s += j;
        }
    }

    private static void print(int i, int j) {
        System.out.println(i + ".." + j);
    }

    public static void main(String[] args) {
        find(15);
    }
}
