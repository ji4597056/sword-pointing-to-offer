package com.github.ji4597056.chapter_26;

import com.github.ji4597056.common.BinaryTreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 26.二叉搜索树与双向链表
 *
 * 输入一棵二叉搜索树,将该二叉搜索树转换成一个排序的双向链表.要求不能创建任何新的结点,只能调整树中结点指针的指向.
 *
 * @author Jeffrey
 * @since 2018/04/10 10:41
 */
public class ConvertNode {

    public BinaryTreeNode convert(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        convert(root, null);
        BinaryTreeNode head = root;
        while (head.getLeft() != null) {
            head = head.getLeft();
        }
        return head;
    }

    private BinaryTreeNode convert(BinaryTreeNode root, BinaryTreeNode lastNode) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode current = root;
        // 遍历连接左子树
        if (current.getLeft() != null) {
            lastNode = convert(current.getLeft(), lastNode);
        }
        current.setLeft(lastNode);
        if (lastNode != null) {
            lastNode.setRight(current);
        }
        // 遍历连接右子树
        lastNode = current;
        if (current.getRight() != null) {
            lastNode = convert(current.getRight(), lastNode);
        }
        return lastNode;
    }

    @Test
    public void test() {
        BinaryTreeNode n1 = new BinaryTreeNode(10);
        BinaryTreeNode n2 = new BinaryTreeNode(6);
        BinaryTreeNode n3 = new BinaryTreeNode(14);
        BinaryTreeNode n4 = new BinaryTreeNode(4);
        BinaryTreeNode n5 = new BinaryTreeNode(8);
        BinaryTreeNode n6 = new BinaryTreeNode(12);
        BinaryTreeNode n7 = new BinaryTreeNode(16);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);
        BinaryTreeNode.inTraverseBinTree(n1);
        BinaryTreeNode convertNode = convert(n1);
        Assert.assertEquals(convertNode, n4);
        convertNode = convertNode.getRight();
        Assert.assertEquals(convertNode, n2);
        convertNode = convertNode.getRight();
        Assert.assertEquals(convertNode, n5);
        convertNode = convertNode.getRight();
        Assert.assertEquals(convertNode, n1);
        convertNode = convertNode.getRight();
        Assert.assertEquals(convertNode, n6);
        convertNode = convertNode.getRight();
        Assert.assertEquals(convertNode, n3);
        convertNode = convertNode.getRight();
        Assert.assertEquals(convertNode, n7);
    }
}

