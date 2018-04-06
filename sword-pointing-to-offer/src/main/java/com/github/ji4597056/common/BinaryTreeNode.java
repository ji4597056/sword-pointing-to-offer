package com.github.ji4597056.common;

/**
 * 二叉树
 *
 * @author Jeffrey
 * @since 2018/04/05 18:54
 */
public class BinaryTreeNode {

    private int value;

    private BinaryTreeNode left;

    private BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    //将二叉树先序遍历，用于测试结果
    public static void preTraverseBinTree(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + ",");
        if (node.left != null) {
            preTraverseBinTree(node.left);
        }
        if (node.right != null) {
            preTraverseBinTree(node.right);
        }
    }

    //将二叉树中序遍历，用于测试结果
    public static void inTraverseBinTree(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inTraverseBinTree(node.left);
        }
        System.out.print(node.value + ",");
        if (node.right != null) {
            inTraverseBinTree(node.right);
        }
    }

    //将二叉树后序遍历，用于测试结果
    public static void postTraverseBinTree(BinaryTreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            postTraverseBinTree(node.left);
        }
        if (node.right != null) {
            postTraverseBinTree(node.right);
        }
        System.out.print(node.value + ",");
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BinaryTreeNode{");
        sb.append("value=").append(value);
        sb.append(", left=").append(left);
        sb.append(", right=").append(right);
        sb.append('}');
        return sb.toString();
    }
}
