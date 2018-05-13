package com.github.ji4597056.chapter_38;

import com.github.ji4597056.common.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 38.chapter_38:二叉树的深度
 *
 * 输入一棵二叉树的根结点,求该树的深度.从根结点到叶结点依次经过的结点(含根、叶结点)形成树的一条路径,最长路径的长度为树的深度.
 *
 * @author Jeffrey
 * @since 2018/05/13 10:42
 */
public class TreeDepth {

    public int treeDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = treeDepth(root.getLeft());
        int right = treeDepth(root.getRight());
        return left > right ? left + 1 : right + 1;
    }

    @Test
    public void test() {
        BinaryTreeNode root=new BinaryTreeNode(1);
        BinaryTreeNode node1=new BinaryTreeNode(2);
        BinaryTreeNode node2=new BinaryTreeNode(3);
        BinaryTreeNode node3=new BinaryTreeNode(4);
        BinaryTreeNode node4=new BinaryTreeNode(5);
        BinaryTreeNode node5=new BinaryTreeNode(6);
        BinaryTreeNode node6=new BinaryTreeNode(7);
        root.setLeft(node1);
        root.setRight(node2);
        node1.setLeft(node3);
        node1.setRight(node4);
        node2.setRight(node5);
        node4.setLeft(node6);
        Assert.assertEquals(4, treeDepth(root));
    }
}
