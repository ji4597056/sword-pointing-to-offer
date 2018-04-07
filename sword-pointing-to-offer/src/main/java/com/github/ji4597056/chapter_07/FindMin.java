package com.github.ji4597056.chapter_07;

import org.junit.Assert;
import org.junit.Test;

/**
 * 7.旋转数组的最小数字
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾,我们称之为数组的旋转.输入一个递增排序的数组的一个旋转,输出旋转数组的最小元素.例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转,该数组的最小值为1.
 *
 * @author Jeffrey
 * @since 2018/04/05 15:30
 */
public class FindMin {

    // 最简单的方法是直接遍历数组可以找到最小数,时间复杂度为O(n),这里不使用
    // 这里使用二分法思想
    public Integer findMinNum(int[] array) {
        if (array == null) {
            return null;
        }
        return findMinNum(array, 0, array.length - 1);
    }

    private Integer findMinNum(int[] array, int low, int high) {
        if (low >= high || array[low] < array[high]) {
            return array[low];
        }
        int mid = (low + high) / 2;
        // 如果array[mid] == array[low] == array[high],无法判断在左半区间还是右半区间
        if (array[low] == array[mid] && array[mid] == array[high]) {
            return findMinNum(array, low + 1, high - 1);
        } else if (array[low] <= array[mid]) {
            return findMinNum(array, mid + 1, high);
        } else {
            return findMinNum(array, low, mid - 1);
        }
    }

    // 非递归实现(与递归思路一样)
    public Integer findMinNum1(int[] array) {
        if (array == null) {
            return null;
        }
        int low = 0, high = array.length - 1;
        while (low < high && array[low] >= array[high]) {
            int mid = (low + high) / 2;
            if (array[low] == array[mid] && array[mid] == array[high]) {
                low++;
                high--;
            } else if (array[low] <= array[mid]) {
                low = ++mid;
            } else {
                high = --mid;
            }
        }
        return array[low];
    }

    @Test
    public void test() {
        int[] array1 = {1, 1, 1, 2, 0};
        int[] array2 = {3, 4, 5, 1, 2};
        int[] array3 = {1, 0, 1, 1, 1};
        int[] array4 = {1, 1, 1, 0, 1};
        Assert.assertEquals(Integer.valueOf(0), findMinNum(array1));
        Assert.assertEquals(Integer.valueOf(1), findMinNum(array2));
        Assert.assertEquals(Integer.valueOf(0), findMinNum(array3));
        Assert.assertEquals(Integer.valueOf(0), findMinNum(array4));

        Assert.assertEquals(Integer.valueOf(0), findMinNum1(array1));
        Assert.assertEquals(Integer.valueOf(1), findMinNum1(array2));
        Assert.assertEquals(Integer.valueOf(0), findMinNum1(array3));
        Assert.assertEquals(Integer.valueOf(0), findMinNum1(array4));
    }
}
