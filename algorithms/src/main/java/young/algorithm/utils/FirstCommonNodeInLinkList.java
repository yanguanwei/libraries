package young.algorithm.utils;

import young.algorithm.data.LinkedListNode;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-30
 */
public class FirstCommonNodeInLinkList {

    /**
     * 查找两个链表的第一个公共结点；
     * 链表尾部对齐，头部裁剪对齐，从裁剪对齐后的头部依次比较找到相同结点。
     */
    public static LinkedListNode find(LinkedListNode list1, LinkedListNode list2) {
        int length1 = count(list1), length2 = count(list2);
        if (length1 > length2) {
            return findCommonNode(
                    get(list1, length1-length2),
                    list2
            );
        } else {
            return findCommonNode(
                    get(list2, length2-length1),
                    list1
            );
        }
    }

    private static LinkedListNode findCommonNode(LinkedListNode list1, LinkedListNode list2) {
        while (list1 != null && list2 != null) {
            if (list1 == list2) {
                return list1;
            }

            list1 = list1.getNext();
            list2 = list2.getNext();
        }

        return null;
    }

    private static LinkedListNode get(LinkedListNode list, int k) {
        while (list != null && k>0) {
            list = list.getNext();
            k--;
        }

        return list;
    }

    private static int count(LinkedListNode list) {
        int length = 0;
        while (list != null) {
            list = list.getNext();
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        /**
         * 1-5\
         *     6-7
         *   2/
         */
        LinkedListNode node1 = new LinkedListNode(1);

        LinkedListNode node5 = new LinkedListNode(5);
        node1.setNext(node5);

        LinkedListNode node6 = new LinkedListNode(6);
        node5.setNext(node6);

        LinkedListNode node7 = new LinkedListNode(7);
        node6.setNext(node7);

        LinkedListNode node2 = new LinkedListNode(2);
        node2.setNext(node6);

        LinkedListNode common = find(node1, node2);
        System.out.println(common);
    }
}
