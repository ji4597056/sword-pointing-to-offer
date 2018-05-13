package com.github.ji4597056.chapter_40;

import org.junit.Assert;
import org.junit.Test;

/**
 * 40.chapter_40:和为s的两个数字VS和为s的连续正数序列
 *
 * 输一个递增排序的数组和一个数字s,在数组中查找两个数使得它们的和正好是s.如果有多对数字的和等于s,输出任意一对即可.例如:输入数组{1,2,4,7,11,15}和数字为15.输出4和11.
 *
 * @author Jeffrey
 * @since 2018/05/13 13:50
 */
public class FindNumberWithSum {

    public boolean findNumberWithSum(int[] data, int sum) {
        boolean found = false;
        if (data == null || data.length < 2) {
            return found;
        }
        int start = 0;
        int end = data.length - 1;
        while (start < end) {
            int num = data[start] + data[end];
            if (num == sum) {
                break;
            } else if (num < sum) {
                start++;
            } else {
                end--;
            }
        }
        if (start < end) {
            found = true;
            System.out.println(data[start]);
            System.out.println(data[end]);
        }
        return found;
    }

    @Test
    public void test() {
        Assert.assertTrue(findNumberWithSum(new int[]{1, 2, 4, 7, 11, 15}, 15));
        Assert.assertTrue(findNumberWithSum(new int[]{1, 2, 4, 7, 11, 15}, 11));
        Assert.assertFalse(findNumberWithSum(new int[]{1, 2, 4, 7, 11, 15}, 7));
    }
}
