package com.github.ji4597056.chapter_37;

import org.junit.Assert;
import org.junit.Test;

/**
 * 37.数字在排序数组中出现的次数
 *
 * 统计一个数字在排序数组中出现的次数.例如输入排序数组{1,2,3,3,3,3,3,4,5}和数字3,由于3在这个数组中出现了4次,因此输出4.
 *
 * @author Jeffrey
 * @since 2018/05/12 20:46
 */
public class NumberOfK {

    public int getNumberOfK(int[] array, int k) {
        // 二分法
        int first = getNumberOfFirstK(array, k, 0, array.length - 1);
        int last = getNumberOfLastK(array, k, 0, array.length - 1);
        if (first != 0 && last != 0) {
            return last - first + 1;
        }
        return 0;
    }

    private int getNumberOfFirstK(int[] array, int k, int start, int end) {
        if (start > end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        if (array[mid] == k) {
            if ((mid > start && array[mid - 1] != k) || mid == start) {
                return mid;
            } else {
                end = mid - 1;
            }
        } else if (array[mid] > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return getNumberOfFirstK(array, k, start, end);
    }

    private int getNumberOfLastK(int[] array, int k, int start, int end) {
        if (start > end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        if (array[mid] == k) {
            if ((mid < end && array[mid + 1] != k) || mid == end) {
                return mid;
            } else {
                start = mid + 1;
            }
        } else if (array[mid] > k) {
            end = mid - 1;
        } else {
            start = mid + 1;
        }
        return getNumberOfLastK(array, k, start, end);
    }

    @Test
    public void test() {
        Assert.assertEquals(4, getNumberOfK(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3));
        Assert.assertEquals(1, getNumberOfK(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 2));
        Assert.assertEquals(0, getNumberOfK(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 6));
    }
}
