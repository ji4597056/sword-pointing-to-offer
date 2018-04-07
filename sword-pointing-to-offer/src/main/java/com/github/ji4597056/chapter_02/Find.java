package com.github.ji4597056.chapter_02;

import org.junit.Assert;
import org.junit.Test;

/**
 * 2.二维数组的查找
 *
 * 一个二维数组,每一行从左到右递增,每一列从上到下递增.输入一个二维数组和一个整数,判断数组中是否含有整数.
 *
 * @author Jeffrey
 * @since 2018/04/05 16:19
 */
public class Find {

    public boolean find(int[][] array, int number) {
        return find(array, array.length, 0, number, array[0].length);
    }

    private boolean find(int[][] array, int i, int j, int num, int high) {
        if (i < 0 || j >= high || array[0][j] > num) {
            return false;
        }
        int p, q;
        // 先确定p(列)
        for (p = 0; p < i; p++) {
            int value = array[j][p];
            if (value > num) {
                break;
            } else if (value == num) {
                return true;
            }
        }
        // 再确定q(行)
        for (q = j; q < high; q++) {
            int value = array[q][p - 1];
            if (value > num) {
                break;
            } else if (value == num) {
                return true;
            }
        }
        return find(array, p - 1, q, num, high);
    }

    /**
     * 1    2    8    9
     * 2    4    9    12
     * 4    7    10   13
     * 6    8    11   15
     */
    @Test
    public void test() {
        int[][] array = new int[4][4];
        array[0][0] = 1;
        array[0][1] = 2;
        array[0][2] = 8;
        array[0][3] = 9;
        array[1][0] = 2;
        array[1][1] = 4;
        array[1][2] = 9;
        array[1][3] = 12;
        array[2][0] = 4;
        array[2][1] = 7;
        array[2][2] = 10;
        array[2][3] = 13;
        array[3][0] = 6;
        array[3][1] = 8;
        array[3][2] = 11;
        array[3][3] = 15;
        Assert.assertTrue(find(array, 1));
        Assert.assertTrue(find(array, 9));
        Assert.assertTrue(find(array, 7));
        Assert.assertTrue(find(array, 11));
        Assert.assertFalse(find(array, 5));
        Assert.assertFalse(find(array, 18));
    }
}
