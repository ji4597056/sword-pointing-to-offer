package com.github.ji4597056.chapter_17;

import com.github.ji4597056.common.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 17.树的子结构
 *
 * 输入两颗二叉树A和B,判断B是不是A的子结构.
 *
 * @author Jeffrey
 * @since 2018/04/08 10:34
 */
public class HasSubTree {

    public boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        // root2为null算作属于root1的子树
        if (root2 == null) {
            return true;
        }
        boolean result = false;
        if (root1 != null) {
            if (root1.getValue() == root2.getValue()) {
                result = doesTreeHaveTree(root1, root2);
            }
            if (!result) {
                result = hasSubTree(root1.getLeft(), root2);
            }
            if (!result) {
                result = hasSubTree(root1.getRight(), root2);
            }
        }
        return result;
    }

    private boolean doesTreeHaveTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.getValue() != root2.getValue()) {
            return false;
        }
        // 递归左右子树
        return doesTreeHaveTree(root1.getLeft(), root2.getLeft()) && doesTreeHaveTree(
            root1.getRight(), root2.getRight());
    }

    @Test
    public void test() {
        BinaryTreeNode root1 = new BinaryTreeNode(8);
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(7);
        BinaryTreeNode node3 = new BinaryTreeNode(9);
        BinaryTreeNode node4 = new BinaryTreeNode(2);
        BinaryTreeNode node5 = new BinaryTreeNode(4);
        BinaryTreeNode node6 = new BinaryTreeNode(7);
        root1.setLeft(node1);
        root1.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node4.setLeft(node5);
        node4.setRight(node6);

        BinaryTreeNode root2 = new BinaryTreeNode(8);
        BinaryTreeNode node21 = new BinaryTreeNode(9);
        BinaryTreeNode node22 = new BinaryTreeNode(2);
        root2.setLeft(node21);
        root2.setRight(node22);

        BinaryTreeNode root3 = new BinaryTreeNode(8);
        BinaryTreeNode node31 = new BinaryTreeNode(9);
        BinaryTreeNode node32 = new BinaryTreeNode(3);
        root3.setLeft(node31);
        root3.setRight(node32);

        Assert.assertTrue(hasSubTree(root1, root2));
        Assert.assertTrue(!hasSubTree(root1, root3));
    }
}
