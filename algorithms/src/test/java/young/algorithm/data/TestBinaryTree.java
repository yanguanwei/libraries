package young.algorithm.data;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author young.alway@gmail.com
 * @since 2014-10-30
 */
public class TestBinaryTree {

    @Test
    public void testDepth() {
        BinaryTree tree = build();
        Assert.assertEquals(4, tree.depth());
    }

    @Test
    public void testIsBalanced() {
        BinaryTree tree = build();
        Assert.assertEquals(true, tree.isBalanced());
    }

    @Test
    public void testIsBalancedImproved() {
        BinaryTree tree = build();
        Assert.assertEquals(true, tree.isBalancedImproved());
    }

    /**
     *     20
     *    /  \
     *   9    23
     *  / \    \
     *  8  10   22
     *  /\
     * 4  5
     */
    private BinaryTree build() {
        BinaryTreeNode root = build(
                20,
                build(
                        9,
                        build(
                                8,
                                build(4),
                                build(5)
                        ),
                        build(10)
                ),
                build(
                        23,
                        null,
                        build(22)
                )
        );

        return new BinaryTree(root);
    }

    private BinaryTreeNode build(int data) {
        return build(data, null, null);
    }

    private BinaryTreeNode build(int data, BinaryTreeNode left, BinaryTreeNode right) {
        return new BinaryTreeNode(data, left, right);
    }
}
