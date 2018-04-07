package com.github.ji4597056.chapter_08;

import org.junit.Assert;
import org.junit.Test;

/**
 * 8.斐波拉契数列
 *
 * 写一个函数,输入n,求斐波那契数列的第n项.
 *
 * 扩展问题:一只青蛙一次可以跳上一级台阶或两级台阶,求青蛙跳上n级台阶共有多少种跳法?
 * n = 1 , f(n) = 1
 * n = 2 , f(n) = 2
 * n = 3 , f(n) = 3 ...
 * 解析:其实这就是斐波拉契数列问题. f(n) = f(n-1) + f(n-2) (n > 2)
 *
 * @author Jeffrey
 * @since 2018/04/06 15:02
 */
public class Fibonacci {

    public long fibonacci(int n) {
        if (n <= 0) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }
        long pre1 = 0L;
        long pre2 = 1L;
        for (int i = 2; i <= n; i++) {
            long tmp = pre2;
            pre2 = pre1 + pre2;
            pre1 = tmp;
        }
        return pre2;
    }

    // 递归实现(涉及到太多重复计算,性能较差)
    public long fibonacci1(int n) {
        if (n <= 0) {
            return 0L;
        }
        if (n == 1) {
            return 1L;
        }
        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    @Test
    public void test() {
        // 0 1 1 2 3 5 8 13 21 34 55
        Assert.assertEquals(1, fibonacci(1));
        Assert.assertEquals(5, fibonacci(5));
        Assert.assertEquals(55, fibonacci(10));

        Assert.assertEquals(1, fibonacci1(1));
        Assert.assertEquals(5, fibonacci1(5));
        Assert.assertEquals(55, fibonacci1(10));
    }
}
