package com.github.ji4597056.chapter_19;

import org.junit.Test;

/**
 * 19.顺时针打印矩阵
 *
 * 输入一个矩阵,按照从外向里以顺时针的顺序依次打印出每一个数字.
 *
 * @author Jeffrey
 * @since 2018/04/08 12:48
 */
public class PrintMatixClockwisely {

    public void printMatixClockwisely(int[][] array) {
        if (array == null) {
            return;
        }
        for (int i = 0, len = array.length, size = (len & 1) == 1 ? len >> 2 + 1 : len >> 2;
            i <= size; i++) {
            printOneCircle(array, i, len);
        }
    }

    private void printOneCircle(int[][] array, int start, int length) {
        int boundary = length - start - 1;
        if (boundary == start) {
            System.out.print(array[start][start]);
            return;
        }
        // 打印左->右
        for (int i = start; i <= boundary; i++) {
            System.out.print(array[start][i] + " ");
        }
        // 打印上->下
        for (int i = start + 1; i <= boundary; i++) {
            System.out.print(array[i][boundary] + " ");
        }
        // 打印右->左
        for (int i = boundary - 1; i >= start; i--) {
            System.out.print(array[boundary][i] + " ");
        }
        // 打印下->上
        for (int i = boundary - 1; i > start; i--) {
            System.out.print(array[i][start] + " ");
        }
    }

    /**
     * 1   2   3   4
     * 5   6   7   8
     * 9   10  11  12
     * 13  14  15  16
     */
    @Test
    public void test() {
        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        printMatixClockwisely(array);
    }
}
