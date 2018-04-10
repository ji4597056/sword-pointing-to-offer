package com.github.ji4597056.chapter_30;

import org.junit.Assert;
import org.junit.Test;

/**
 * 30.连续子数组的最大和
 *
 * 输入一个整型数组,数组里有正数也有负数.数组中一个或连续的多个整数组成一个子数组.求所有子数组的和的最大值.要求时间复杂度为O(n).例如输入的数组为{1,-2,3,10,-4,7,2,-5},和最大的子数组为{3,10,-4,7,2}.
 *
 * @author Jeffrey
 * @since 2018/04/11 0:35
 */
public class FindGreatestSubArray {

    // f(i) = array[i]              i = 0 || f(i-1)<=0
    // f(i) = f(i-1) + array[i]     i != 0 && f(i-1)>0
    public int findGreatestSubArray(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = array[0];
        int acc = max;
        for (int i = 1, len = array.length; i < len; i++) {
            if (acc <= 0) {
                acc = array[i];
            } else {
                acc += array[i];
            }
            max = max > acc ? max : acc;
        }
        return max;
    }

    @Test
    public void test() {
        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
        Assert.assertEquals(18, findGreatestSubArray(array));
    }
}
