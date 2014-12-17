package young.algorithm.utils;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-30
 */
public class Find2NumbersWithSumInArray {

    /**
     * �ڵ������������array�У��ҳ�����Ԫ�صĺ�Ϊsum��
     * ������������Ԫ�ء�
     *
     * �趨����ָ��i, j�ֱ�ָ��������׺�β�����i, jָ�������
     * ����sum��j�����ƶ���ʹ�ͱ�С��
     * ����sub��i�����ƶ���ʹ�ͱ��
     */
    public static int[] find(int[] array, int sum) {
        int i=0, j=array.length-1, s;
        while (i<j) {
            s = array[i] + array[j];
            if (s < sum) {
                i++;
            } else if (s > sum) {
                j--;
            } else {
                return new int[] {array[i], array[j]};
            }
        }

        return null;
    }
}
