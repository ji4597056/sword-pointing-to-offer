package com.github.ji4597056.chapter_45;

import org.junit.Assert;
import org.junit.Test;

/**
 * 45.求1+2+...+n
 *
 * 求1+2+...+n,要求不能用除法、for、while、if、else、switch、case等关键字及条件判断语句(A?B:C).
 *
 * @author Jeffrey
 * @since 2018/05/28 3:57 PM
 */
public class SumSolution {

    public int sumSolution(int n) {
        int result = n;
        boolean value = (n > 0) && ((result += sumSolution(n - 1)) == 0);
        return result;
    }

    @Test
    public void test() {
        Assert.assertEquals(55, sumSolution(10));
    }
}
