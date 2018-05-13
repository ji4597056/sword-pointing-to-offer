package com.github.ji4597056.chapter_05;

import com.github.ji4597056.common.BinaryTreeNode;
import org.junit.Test;

/**
 * 5.重建二叉树
 *
 * 输入二叉树的前序遍历和中序遍历的结果,重建出该二叉树.假设前序遍历和中序遍历结果中都不包含重复的数字.
 *
 * @author Jeffrey
 * @since 2018/04/05 15:30
 */
public class RebuildBinaryTree {

    public BinaryTreeNode construct(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        return constructBinaryTree(preorder, inorder, 0, preorder.length - 1, 0,
            inorder.length - 1);
    }

    private BinaryTreeNode constructBinaryTree(int[] pre, int[] in, int preStart,
        int preEnd, int inStart, int inEnd) {
        BinaryTreeNode tree = new BinaryTreeNode(pre[preStart]);
        if (preStart == preEnd && inStart == inEnd) {
            return tree;
        }
        // 找到前序遍历头节点在中序遍历中的位置,这样就可以获取左右子树的长度
        int root;
        for (root = inStart; root < inEnd; root++) {
            if (in[root] == pre[preStart]) {
                break;
            }
        }
        // 左子树长度
        int leftLength = root - inStart;
        // 右子树长度
        int rightLength = inEnd - root;
        // 构建左子树
        if (leftLength > 0) {
            tree.setLeft(
                constructBinaryTree(pre, in, preStart + 1, preStart + leftLength, inStart,
                    root - 1));
        }
        // 构建右子树
        if (rightLength > 0) {
            tree.setRight(
                constructBinaryTree(pre, in, preStart + 1 + leftLength, preEnd, root + 1, inEnd));
        }
        return tree;
    }

    @Test
    public void test() {
        int[] preSort = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inSort = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTreeNode root = construct(preSort, inSort);
        BinaryTreeNode.preTraverseBinTree(root);
        System.out.println();
        BinaryTreeNode.inTraverseBinTree(root);
        System.out.println();
        BinaryTreeNode.postTraverseBinTree(root);
    }
}
