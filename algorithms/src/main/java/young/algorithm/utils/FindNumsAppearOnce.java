package young.algorithm.utils;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-30
 */
public class FindNumsAppearOnce {

    /**
     * array������ֻ������Ԫ�ص�ֵֻ����һ�Σ�����Ԫ�ض��������Σ�
     * ���һ��������ֻ��һ��Ԫ�ص�ֵֻ����һ�Σ�����Ԫ�ض��������Σ����������������������ֻ�ֳ�һ�ε�ֵ��
     * ������ֳ����������飬ÿ�������������������
     */
    public static int[] find(int[] array) {
        int xor = 0;

        for (int d : array) {
            xor ^= d;
        }
        //��ʱxor��ֵ������������ֻ����һ�ε�����ֵ����򣬲������ֵһ����Ϊ0
        //�ҳ���һ��1���ֵ�λ��
        int i = findFirstBitIs1(xor);

        //����iλ��Ϊ1��������������ֳ�����������
        //�϶����԰�������ֻ����һ�ε�Ԫ�ػ��ֵ���ͬ����������
        //����Ԫ����ͬ��ֻ�Ữ�ֵ�ͬһ����������
        int a = 0, b = 0;
        for (int d : array) {
            if (isBit1(d, i)) {
                a ^= d;
            } else {
                b ^= d;
            }
        }

        return new int[] {a, b};
    }

    private static int findFirstBitIs1(int d) {
        int i = 0;
        while ((d & 1) == 0 && i < 32) {
            d = d >>> 1;
            i++;
        }

        return i;
    }

    private static boolean isBit1(int d, int i) {
        d = d >>> i;
        return (d & 1) == 1;
    }
}
