package young.algorithm.data;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-30
 */
public class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    /**
     *
     * @return ��ȣ����Ϊ��������0
     */
    public int depth() {
        return resolveDepth(root);
    }

    /**
     * �ݹ������ǰ���node����ȡ�
     */
    private int resolveDepth(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = resolveDepth(node.getLeft());
        int rightDepth = resolveDepth(node.getRight());

        return (leftDepth > rightDepth ? leftDepth : rightDepth) + 1;
    }

    /**
     * �жϸ����Ƿ�Ϊƽ�������
     */
    public boolean isBalanced() {
        return isBalancedRecursively(root);
    }

    /**
     * �жϸ����Ƿ�Ϊƽ�������
     */
    public boolean isBalancedImproved() {
        return isBalancedRecursivelyImproved(root, new MutableInteger(0));
    }

    /**
     * ��������������ж��Ƿ�Ϊƽ��
     */
    private boolean isBalancedRecursively(BinaryTreeNode node) {
        if (node == null) {
            return true;
        }

        int leftDepth = resolveDepth(node.getLeft());
        int rightDepth = resolveDepth(node.getRight());
        int diff = leftDepth - rightDepth;
        return -1 <= diff && diff <= 1
                && isBalancedRecursively(node.getLeft())
                && isBalancedRecursively(node.getRight());
    }

    /**
     * ��������������ж����������Ƿ�Ϊƽ���ͬʱ��Ҳȡ�����������������
     */
    private boolean isBalancedRecursivelyImproved(BinaryTreeNode node, MutableInteger depth) {
        if (node == null) {
            depth.setValue(0);
            return true;
        }

        MutableInteger leftDepth = new MutableInteger(0);
        MutableInteger rightDepth = new MutableInteger(0);
        if (isBalancedRecursivelyImproved(node.getLeft(), leftDepth)) {
            if (isBalancedRecursivelyImproved(node.getRight(), rightDepth)) {
                int left = leftDepth.getValue();
                int right = rightDepth.getValue();
                depth.setValue((left > right ? left : right) + 1);

                int diff = left - right;
                if (-1 <= diff && diff <= 1) {
                    return true;
                }
            }
        }

        return false;
    }
}
