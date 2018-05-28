package com.github.ji4597056.chapter_42;

import org.junit.Test;

/**
 * 42.n个骰子的点数
 *
 * 把n个骰子扔在地上,所有骰子朝上一面的点数之和为s.输入n,打印出s的所有可能的值出现的概率.
 *
 * @author Jeffrey
 * @since 2018/05/15 17:13
 */
public class PrintProbability {

    public void printProbability(int number) {
        if (number < 1) {
            return;
        }
        int[][] probabilities = new int[2][];
        int gMaxValue = 6;
        probabilities[0] = new int[gMaxValue * number + 1];
        probabilities[1] = new int[gMaxValue * number + 1];
        int flag = 0;
        // 赋初始值
        for (int i = 1; i <= gMaxValue; i++) {
            probabilities[flag][i] = 1;
        }
        for (int i = 2; i <= number; i++) {
            probabilities[1 - flag][i - 1] = 0;
            for (int j = i; j <= gMaxValue * i; j++) {
                probabilities[1 - flag][j] = 0;
                for (int k = j - gMaxValue; k < j; k++) {
                    if (k > 0) {
                        probabilities[1 - flag][j] += probabilities[flag][k];
                    }
                }
            }
            flag = 1 - flag;
        }
        double total = Math.pow(gMaxValue, number);
        for (int i = number; i <= gMaxValue * number; i++) {
            System.out.println(i + ":" + probabilities[flag][i] + "/" + total);
        }
    }

    @Test
    public void test() {
        printProbability(2);
        System.out.println("==========");
        printProbability(3);
    }
}
