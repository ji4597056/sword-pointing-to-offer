package com.github.ji4597056.chapter_38;

import com.github.ji4597056.common.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * chapter_38:二叉树的深度
 *
 * 输入一棵二叉树的根结点,判断该树是不是平衡二叉树.如果某二叉树中任意结点的左右子树的深度相差不超过1,那么他就是一棵平衡二叉树.
 *
 * @author Jeffrey
 * @since 2018/05/13 10:48
 */
public class BalancedTree {

    public boolean isBalanced(BinaryTreeNode root) {
        return isBalanced(root, new Depth(0));
    }

    private boolean isBalanced(BinaryTreeNode node, Depth depth) {
        if (node == null) {
            return true;
        }
        Depth left = new Depth(0);
        Depth right = new Depth(0);
        if (isBalanced(node.getLeft(), left) && isBalanced(node.getRight(), right)) {
            depth.depth = Math.abs(left.depth - right.depth) + 1;
            return Math.abs(left.depth - right.depth) <= 1;
        }
        return false;
    }

    private class Depth {

        int depth;

        Depth(int depth) {
            this.depth = depth;
        }
    }

    @Test
    public void test() {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(6);
        BinaryTreeNode node6 = new BinaryTreeNode(7);
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setRight(node5);
        node4.setLeft(node6);
        Assert.assertTrue(isBalanced(root));
        BinaryTreeNode node7 = new BinaryTreeNode(8);
        node6.setLeft(node7);
        Assert.assertFalse(isBalanced(root));
    }
}
