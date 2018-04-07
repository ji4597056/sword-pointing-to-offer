package com.github.ji4597056.chapter_11;

import org.junit.Test;

/**
 * 11.打印1到最大的n位数
 *
 * 输入数字n,按顺序打印出从1到最大的n位进制数.比如输入3,则打印出1、2、3一直到999.
 *
 * @author Jeffrey
 * @since 2018/04/05 15:30
 */
public class PrintMaxOfNDigits {

    public void printToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        int[] number = new int[n];
        printToMaxOfNDigitsRecursively(number, n, 0);
    }

    private void printToMaxOfNDigitsRecursively(int[] number, int length, int index) {
        if (index == length) {
            printNumber(number);
            return;
        }
        // 递归全排列
        for (int i = 0; i < 10; i++) {
            number[index] = i;
            printToMaxOfNDigitsRecursively(number, length, index + 1);
        }
    }

    // 打印数字 098 -> 98
    private void printNumber(int[] number) {
        boolean isBeginning = true;
        for (int i = 0; i < number.length; i++) {
            if (isBeginning && number[i] != 0) {
                isBeginning = false;
            }
            if (!isBeginning) {
                System.out.print(number[i]);
            }
        }
        // 为0时不打印不换行
        if (!isBeginning) {
            System.out.println();
        }
    }

    @Test
    public void test() {
        printToMaxOfNDigits(1);
        System.out.println("===========");
        printToMaxOfNDigits(3);
        System.out.println("===========");
        printToMaxOfNDigits(5);
    }
}
