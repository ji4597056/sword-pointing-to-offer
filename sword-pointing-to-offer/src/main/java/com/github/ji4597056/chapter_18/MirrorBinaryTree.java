package com.github.ji4597056.chapter_18;

import com.github.ji4597056.common.BinaryTreeNode;
import org.junit.Test;

/**
 * 18.二叉树的镜像
 *
 * 请完成一个函数,输入一个二叉树,该函数输出它的镜像.
 *
 * @author Jeffrey
 * @since 2018/04/08 11:21
 */
public class MirrorBinaryTree {

    public BinaryTreeNode mirrorBinaryTree(BinaryTreeNode root) {
        if (root == null || (root.getLeft() == null && root.getRight() == null)) {
            return null;
        }
        // 交换左右子树
        BinaryTreeNode tmp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(tmp);
        mirrorBinaryTree(root.getLeft());
        mirrorBinaryTree(root.getRight());
        return root;
    }

    @Test
    public void test() {
        BinaryTreeNode root = new BinaryTreeNode(8);
        BinaryTreeNode node1 = new BinaryTreeNode(8);
        BinaryTreeNode node2 = new BinaryTreeNode(7);
        BinaryTreeNode node3 = new BinaryTreeNode(9);
        BinaryTreeNode node4 = new BinaryTreeNode(2);
        BinaryTreeNode node5 = new BinaryTreeNode(4);
        BinaryTreeNode node6 = new BinaryTreeNode(7);
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node4.setLeft(node5);
        node4.setRight(node6);
        BinaryTreeNode.levelTraverseBinTree(root);
        mirrorBinaryTree(root);
        System.out.println("\n============");
        BinaryTreeNode.levelTraverseBinTree(root);
    }
}
