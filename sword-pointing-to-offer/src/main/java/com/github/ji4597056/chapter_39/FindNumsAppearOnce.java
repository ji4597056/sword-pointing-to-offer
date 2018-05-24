package com.github.ji4597056.chapter_39;

import org.junit.Test;

/**
 * 39.数组中只出现一次的数字
 *
 * 一个整型数组里除了两个数字之外,其他的数字都出现了两次.请写程序找出这两个只出现一次的数字.要求时间复杂度是O(n),空间复杂度为O(1).
 *
 * @author Jeffrey
 * @since 2018/05/13 13:30
 */
public class FindNumsAppearOnce {

    public void findNumsAppearOnce(int[] array) {
        if (array == null) {
            return;
        }
        // 使用异或运算区分再求解
        int resultExclusiveOR = 0;
        for (int i : array) {
            resultExclusiveOR ^= i;
        }
        int index = findFirstBitIs1(resultExclusiveOR);
        int num1 = 0;
        int num2 = 0;
        for (int i : array) {
            if (isBit1(i, index)) {
                num1 ^= i;
            } else {
                num2 ^= i;
            }
        }
        System.out.println(num1);
        System.out.println(num2);
    }

    private int findFirstBitIs1(int number) {
        int indexBit = 0;
        while ((number & 1) == 0) {
            number = number >> 1;
            ++indexBit;
        }
        return indexBit;
    }

    private boolean isBit1(int number, int index) {
        number = number >> index;
        return (number & 1) == 0;
    }

    @Test
    public void test() {
        findNumsAppearOnce(new int[]{2, 4, 3, 6, 3, 2, 5, 5});
    }
}
