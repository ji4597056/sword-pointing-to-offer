package com.github.ji4597056.chapter_28;

import org.junit.Assert;
import org.junit.Test;

/**
 * 28.数组中出现次数超过一半的数组
 *
 * 数组中有一个数字出现次数超过数组长度的一半,请找出这个数字.例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}.2出现的次数超过数组长度的一半，因此输出2.
 *
 * @author Jeffrey
 * @since 2018/04/10 22:37
 */
public class MoreThanHalfNum {

    // 1.基于partition的算法,超过数组长度一半的数一定是中位数
    public Integer moreThanHalfNum(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int mid = array.length >> 1 + 1;
        int start = 0;
        int end = array.length - 1;
        int index = partition(array, start, end);
        // 找中位数
        while (index != mid) {
            if (index < mid) {
                start = index + 1;
                index = partition(array, start, end);
            } else {
                end = index - 1;
                index = partition(array, start, end);
            }
        }
        // 检查是否超过一半
        return checkMoreThanHalf(array, array[mid]) ? array[mid] : null;
    }

    // 切分
    private int partition(int[] array, int low, int high) {
        int value = array[low];
        int i = low;
        int j = high;
        while (true) {
            while (array[++i] <= value) {
                if (i == high) {
                    break;
                }
            }
            while (array[--j] >= value) {
                if (j == low) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            swap(array, i, j);
        }
        swap(array, low, j);
        return j;
    }

    private boolean checkMoreThanHalf(int[] array, int num) {
        int times = 0;
        for (int anArray : array) {
            if (anArray == num) {
                times++;
            }
        }
        return times << 2 > array.length;
    }

    private void swap(int[] array, int m, int n) {
        int temp = array[m];
        array[m] = array[n];
        array[n] = temp;
    }

    // 2.根据数组特点的算法,超过数组长度一半的数一定比其他数字之和还要多
    public Integer moreThanHalfNum1(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int result = array[0];
        int times = 1;
        for (int i = 1, len = array.length; i < len; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (array[i] == result) {
                times++;
            } else {
                times--;
            }
        }
        return checkMoreThanHalf(array, result) ? result : null;
    }

    @Test
    public void test() {
        int[] array1 = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        Assert.assertEquals(Integer.valueOf(2), moreThanHalfNum(array1));
        Assert.assertEquals(Integer.valueOf(2), moreThanHalfNum1(array1));
        int[] array2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Assert.assertNull(moreThanHalfNum(array2));
        Assert.assertNull(moreThanHalfNum1(array2));
    }
}
