package com.github.ji4597056.chapter_13;

import java.util.Arrays;
import java.util.function.Predicate;
import org.junit.Test;

/**
 * 13.调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组,实现一个函数来调整该函数数组中数字的顺序,使得所有奇数位于数组的前半部分,所有的偶数位于数组的后半部分.
 *
 * @author Jeffrey
 * @since 2018/04/07 11:35
 */
public class ReOrder {

    public void reorderOddEven(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }
        reorderOddEven(array, i -> (i & 1) == 0);
    }

    // 切分思想
    private void reorderOddEven(int[] array, Predicate<Integer> predicate) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            // 从头部找第一个偶数
            while (start < end && predicate.test(array[start])) {
                start++;
            }
            // 从尾部找第一个奇数
            while (start < end && !predicate.test(array[end])) {
                end--;
            }
            int tmp = array[end];
            array[end] = array[start];
            array[start] = tmp;
        }
    }

    @Test
    public void test() {
        int[] array = new int[]{5, 4, 3, 2, 1, 6, 7, 8, 9};
        reorderOddEven(array);
        Arrays.stream(array).forEach(System.out::println);
    }
}
