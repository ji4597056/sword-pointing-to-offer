package com.github.ji4597056.chapter_23;

import org.junit.Assert;
import org.junit.Test;

/**
 * 23.二叉搜索树的后序遍历序列
 *
 * 输入一个整数数组,判断该数组是不是某二叉搜索树的后序遍历的结果.是则返回true,否则返回false.
 *
 * @author Jeffrey
 * @since 2018/04/09 11:07
 */
public class VerfiySequenceOfBST {

    public boolean verfiySequenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        return verfiySequenceOfBST(sequence, 0, sequence.length - 1);
    }

    // 递归
    private boolean verfiySequenceOfBST(int[] sequence, int start, int end) {
        // 最后一个节点一定是根节点
        int root = sequence[end];
        // 找出第一个大于根节点的节点,即右子树的第一个节点
        int i = start;
        for (; i < end; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        int j = i + 1;
        // 如果右子树存在小于根节点的节点,即不满足二叉树搜索树定义
        for (; j < end; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        // 判断左右子树是否满足定义
        boolean left = true;
        boolean right = true;
        if (i > start) {
            left = verfiySequenceOfBST(sequence, start, i - 1);
        }
        if (i < end - 1) {
            right = verfiySequenceOfBST(sequence, i, end - 1);
        }
        return left && right;
    }

    /**
     * #         8
     * #     6       10
     * #  5    7   9    11
     */
    @Test
    public void test() {
        int[] array1 = {5, 7, 6, 9, 11, 10, 8};
        int[] array2 = {5, 7, 6, 11, 9, 10, 8};
        Assert.assertTrue(verfiySequenceOfBST(array1));
        Assert.assertFalse(verfiySequenceOfBST(array2));
    }
}
