package com.github.ji4597056.chapter_44;

import org.junit.Assert;
import org.junit.Test;

/**
 * 44.圈中最后剩下的数字
 *
 * 0,1,...,n-1这n个数排成一个圆圈,从数字0开始每次从这个圆圈里删除第m个数字.求出这个圆圈里剩下的最后一个数字.
 *
 * @author Jeffrey
 * @since 2018/05/28 12:42 PM
 */
public class LastRemaining {

    public int lastRemaining(int n, int m) {
        //f(n,m) = [f(n-1,m) + m] % n   (n > 1)
        if (n < 1 || m < 1) {
            return -1;
        }
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, lastRemaining(5, 3));
    }
}
