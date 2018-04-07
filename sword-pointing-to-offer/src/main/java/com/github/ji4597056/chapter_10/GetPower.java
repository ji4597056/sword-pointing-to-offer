package com.github.ji4597056.chapter_10;

import org.junit.Assert;
import org.junit.Test;

/**
 * 10.数值的整数次方
 *
 * 实现函数`double Power（double base，int exponent）`,求base的exponent次方.不得使用库函数,同时不需要考虑大数问题.
 *
 * @author Jeffrey
 * @since 2018/04/05 15:30
 */
public class GetPower {

    public double power(double base, int exponent) throws Exception {
        if (equal(base, 0.0) && exponent < 0) {
            throw new Exception("0的负数次幂没有意义!");
        }
        if (exponent < 0) {
            return 1.0 / powerWithExpoment(base, -exponent);
        } else {
            return powerWithExpoment(base, exponent);
        }
    }

    private double powerWithExpoment(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        // 为提高效率,这里不使用累乘base
        // a^n = a^(n/2) * a^(n/2) (n为偶数)
        // a^n = a^((n-1)/2) * a^((n-1)/2) * a (n为奇数)
        double result = powerWithExpoment(base, exponent >> 1);
        result *= result;
        // 位与运算判断奇数
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }

    private boolean equal(double num1, double num2) {
        return (num1 - num2 > -0.0000001) && num1 - num2 < 0.0000001;
    }

    @Test
    public void test() throws Exception {
        Assert.assertTrue(equal(4.0, power(2.0, 2)));
        Assert.assertTrue(equal(0.25, power(2.0, -2)));
        Assert.assertTrue(equal(8.0, power(2.0, 3)));
        Assert.assertTrue(equal(0.125, power(2.0, -3)));
    }
}
