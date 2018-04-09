package com.github.ji4597056.chapter_24;

import com.github.ji4597056.common.BinaryTreeNode;
import java.util.Stack;
import org.junit.Test;

/**
 * 24.二叉树中和为某一值的路径
 *
 * 输入一颗二叉树和一个整数,打印出二叉树中结点值的和为输入整数的所有路径.从树的根节点开始往下一直到叶结点所经过的结点形成一条路径.
 *
 * @author Jeffrey
 * @since 2018/04/09 12:53
 */
public class FindPath {

    public void findPath(BinaryTreeNode root, int sum) {
        if (root == null) {
            return;
        }
        Stack<Integer> stack = new Stack<>();
        findPath(root, sum, 0, stack);
    }

    private void findPath(BinaryTreeNode root, int sum, int currentSum, Stack<Integer> stack) {
        currentSum += root.getValue();
        stack.push(root.getValue());
        // 如果中途已经>=sum(还没到叶子节点)则直接出栈
        if (!(currentSum >= sum && (root.getLeft() != null || root.getRight() != null))) {
            if (root.getRight() == null && root.getRight() == null && currentSum == sum) {
                for (Integer value : stack) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
            if (root.getLeft() != null) {
                findPath(root.getLeft(), sum, currentSum, stack);
            }
            if (root.getRight() != null) {
                findPath(root.getRight(), sum, currentSum, stack);
            }
        }
        stack.pop();
    }

    @Test
    public void test() {
        BinaryTreeNode node1 = new BinaryTreeNode(10);
        BinaryTreeNode node2 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(12);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(7);
        node1.setLeft(node2);
        node1.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        findPath(node1, 22);
    }
}
