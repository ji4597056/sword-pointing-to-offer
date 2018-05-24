package com.github.ji4597056.chapter_33;

import org.junit.Assert;
import org.junit.Test;

/**
 * 33.丑数
 *
 * 我们把只包含因子2,3,和5的称为丑数.求按从小到大的顺序的第1500个丑数.例如6、8都是丑数,但14不是,因为它包含因子7.习惯上我们把1当做第一个丑数.
 *
 * @author Jeffrey
 * @since 2018/05/11 22:16
 */
public class UglyNum {

    public int getUglyNumber(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("error n!");
        }
        if (n == 1) {
            return 1;
        }
        // 空间换时间
        int[] uglyNums = new int[1500];
        uglyNums[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for (int i = 1, len = uglyNums.length; i < len; i++) {
            int min = min(uglyNums[index2] * 2, uglyNums[index3] * 3, uglyNums[index5] * 5);
            if (min == uglyNums[index2] * 2) {
                index2++;
            }
            if (min == uglyNums[index3] * 3) {
                index3++;
            }
            if (min == uglyNums[index5] * 5) {
                index5++;
            }
            uglyNums[i] = min;
        }
        return uglyNums[n - 1];
    }

    private int min(int a, int b, int c) {
        return a < b ? (a < c ? a : c) : (b < c ? b : c);
    }

    @Test
    public void test() {
        Assert.assertEquals(1, getUglyNumber(1));
        Assert.assertEquals(3, getUglyNumber(3));
        Assert.assertEquals(5, getUglyNumber(5));
        System.out.println(getUglyNumber(1500));
    }
}
