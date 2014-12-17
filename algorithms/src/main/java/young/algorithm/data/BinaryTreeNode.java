package young.algorithm.data;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-30
 */
public class BinaryTreeNode {
    private Object data;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(Object data) {
        this.data = data;
    }

    public BinaryTreeNode(Object data, BinaryTreeNode left, BinaryTreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}
