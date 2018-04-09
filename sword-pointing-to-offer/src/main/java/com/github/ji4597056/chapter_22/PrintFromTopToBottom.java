package com.github.ji4597056.chapter_22;

import com.github.ji4597056.common.BinaryTreeNode;
import java.util.LinkedList;
import org.junit.Test;

/**
 * 22.从上往下打印二叉树
 *
 * 从上往下打印二叉树的每个结点,同一层的结点按照从左到右的顺序打印.
 *
 * @author Jeffrey
 * @since 2018/04/09 10:48
 */
public class PrintFromTopToBottom {

    public void printFromTopToBottom(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode cur = queue.pop();
            System.out.print(cur.getValue() + " ");
            if (cur.getLeft() != null) {
                queue.offer(cur.getLeft());
            }
            if (cur.getRight() != null) {
                queue.offer(cur.getRight());
            }
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
        node4.setLeft(node5);
        node4.setRight(node6);
        printFromTopToBottom(root);
    }
}
