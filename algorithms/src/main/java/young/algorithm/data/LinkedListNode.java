package young.algorithm.data;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-30
 *
 * 单链表结点
 */
public class LinkedListNode {
    private Object data;
    private LinkedListNode next;

    public LinkedListNode() {

    }

    public LinkedListNode(Object data) {
        this(data, null);
    }

    public LinkedListNode(Object data, LinkedListNode next) {
        this.data = data;
        this.next = next;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public String toString() {
        return data.toString();
    }
}
