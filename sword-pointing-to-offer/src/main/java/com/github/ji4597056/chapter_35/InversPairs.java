package com.github.ji4597056.chapter_35;

import org.junit.Assert;
import org.junit.Test;

/**
 * 35.chapter_35:数组中的逆序对
 *
 * 在数组中的两个数字如果前一个数字大于后一个数字,则这两个数字组成一个逆序对.输入一个数组,求出这个数组的逆序对的总数.例如在数组{7,5,6,4}中,一共存在5个逆序对,分别是(7,6)、(7,5)、(7,4)、(6,4)、(5,4).
 *
 * @author Jeffrey
 * @since 2018/05/12 9:26
 */
public class InversPairs {

    public int inversePairs(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        // 不能破坏原数组,所以需要array.clone(),归并排序需要额外的array.clone()
        return mergeSort(array.clone(), array.clone(), 0, array.length - 1);
    }

    private int mergeSort(int[] copy1, int[] copy2, int start, int end) {
        if (start == end) {
            copy2[start] = copy1[start];
            return 0;
        }
        int mid = start + (end - start) / 2; // 不能直接(start + end)/2,防止溢出
        // 交换了copy1和copy2的位置
        int left = mergeSort(copy2, copy1, start, mid);
        int right = mergeSort(copy2, copy1, mid + 1, end);
        int count = 0;
        // 判断是否有序,无序则merge
        if (copy1[mid] > copy1[mid + 1]) {
            // 归并并计算count(为了计算逆序数,这里需要逆序复制)
            int leftIndex = mid;
            int rightIndex = end;
            while (leftIndex >= start && rightIndex >= mid + 1) {
                if (copy1[leftIndex] > copy1[rightIndex]) {
                    copy2[end--] = copy1[leftIndex--];
                    count += rightIndex - mid;
                } else {
                    copy2[end--] = copy1[rightIndex--];
                }
            }
            while (leftIndex >= start) {
                copy2[end--] = copy1[leftIndex--];
            }
            while (rightIndex >= mid + 1) {
                copy2[end--] = copy1[rightIndex--];
            }
        }
        return left + right + count;
    }

    @Test
    public void test() {
        Assert.assertEquals(5, inversePairs(new int[]{7, 5, 6, 4}));
        Assert.assertEquals(1, inversePairs(new int[]{7, 5}));
        Assert.assertEquals(6, inversePairs(new int[]{4, 3, 2, 1}));
        Assert.assertEquals(6, inversePairs(new int[]{4, 3, 2, 1, 5}));
    }
}
