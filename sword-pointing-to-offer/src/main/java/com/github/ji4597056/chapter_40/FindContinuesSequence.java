package com.github.ji4597056.chapter_40;

import org.junit.Test;

/**
 * 40.和为s的两个数字VS和为s的连续正数序列
 *
 * 输入一个正数s,打印出所有和为s的连续正数序列(至少含两个数).例如输入15,由于1+2+3+4+5=4+5+6=7+8=15,所以结果打印出3个连续序列1-5、4-6、和7-8.
 *
 * @author Jeffrey
 * @since 2018/05/13 14:05
 */
public class FindContinuesSequence {

    public void findContinuesSequence(int sum) {
        if (sum < 3) {
            return;
        }
        int i = 1;
        int j = 2;
        while (i < j) {
            int num = (i + j) * (j - i + 1) / 2; //求和
            if (num == sum) {
                for (int k = i; k <= j; k++) {
                    System.out.print(k + " ");
                }
                System.out.println();
                j++;
            } else if (num < sum) {
                j++;
            } else {
                i++;
            }
        }
    }

    @Test
    public void test() {
        findContinuesSequence(15);
    }
}
