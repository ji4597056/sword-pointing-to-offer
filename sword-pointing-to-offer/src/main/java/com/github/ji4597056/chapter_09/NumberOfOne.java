package com.github.ji4597056.chapter_09;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Jeffrey
 * @since 2018/04/06 15:33
 */
public class NumberOfOne {

    // 常规思路
    public static int numberOfOne1(int n) {
        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                count++;
            }
            flag <<= 1;
        }
        return count;
    }

    // 加分思路
    public static int numberOfOne2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = (n - 1) & n; // n = (n - 1) & n 表示把n最右边的1变成0
        }
        return count;
    }

    @Test
    public void test() {
        System.out.println(Integer.toBinaryString(1));
        System.out.println(Integer.toBinaryString(100));
        System.out.println(Integer.toBinaryString(-100));

        Assert.assertEquals(0, numberOfOne1(0));
        Assert.assertEquals(1, numberOfOne1(1));
        Assert.assertEquals(3, numberOfOne1(100));
        Assert.assertEquals(28, numberOfOne1(-100));

        Assert.assertEquals(0, numberOfOne2(0));
        Assert.assertEquals(1, numberOfOne2(1));
        Assert.assertEquals(3, numberOfOne2(100));
        Assert.assertEquals(28, numberOfOne2(-100));
    }
}
