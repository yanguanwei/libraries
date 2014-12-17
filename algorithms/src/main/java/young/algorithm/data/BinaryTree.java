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
     * @return 深度，如果为空树返回0
     */
    public int depth() {
        return resolveDepth(root);
    }

    /**
     * 递归解析当前结点node的深度。
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
     * 判断该树是否为平衡二叉树
     */
    public boolean isBalanced() {
        return isBalancedRecursively(root);
    }

    /**
     * 判断该树是否为平衡二叉树
     */
    public boolean isBalancedImproved() {
        return isBalancedRecursivelyImproved(root, new MutableInteger(0));
    }

    /**
     * 利用树的深度来判断是否为平衡
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
     * 后序遍历树，在判断左右子树是否为平衡的同时，也取得了左右子树的深度
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
