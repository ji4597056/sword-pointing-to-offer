package com.github.ji4597056.chapter_32;

import java.util.Arrays;
import org.junit.Test;

/**
 * 32.把数组排成最小的数
 *
 * 输入一个正整数数组,把数组里所有数字拼接起来排成一个数,打印能拼接出的所有数字的最小的一个.例如输入{3,32,321},则打印最小的数字是321323.
 *
 * @author Jeffrey
 * @since 2018/04/11 14:59
 */
public class PrintMin {

    public void printMin(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        printMinNumber(array, 0, array.length - 1);
        Arrays.stream(array).forEach(System.out::print);
    }

    // 快速排序
    private void printMinNumber(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right + 1;
        int curr = array[left];
        while (true) {
            while (isSmall(array[++i], curr)) {
                if (i == right) {
                    break;
                }
            }
            while (isSmall(curr, array[--j])) {
                if (j == left) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
        array[left] = array[j];
        array[j] = curr;
        printMinNumber(array, left, j - 1);
        printMinNumber(array, j + 1, right);
    }

    // 考虑到大数问题需要把数字转化为字符串
    // m < n 则 "mn" < "nm" 反之亦然
    private boolean isSmall(int m, int n) {
        String mStr = String.valueOf(m);
        String nStr = String.valueOf(n);
        String left = mStr + nStr;
        String right = nStr + mStr;
        for (int i = 0, len = left.length(); i < len; i++) {
            if (left.charAt(i) < right.charAt(i)) {
                return Boolean.TRUE;
            } else if (left.charAt(i) > right.charAt(i)) {
                return Boolean.FALSE;
            }
        }
        return Boolean.FALSE;
    }

    @Test
    public void test() {
        printMin(new int[]{3, 32, 321});
        System.out.println();
        printMin(new int[]{12, 21, 123, 321});
    }
}
