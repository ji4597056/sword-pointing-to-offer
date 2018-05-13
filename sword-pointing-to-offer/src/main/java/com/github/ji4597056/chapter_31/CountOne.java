package com.github.ji4597056.chapter_31;

import org.junit.Assert;
import org.junit.Test;

/**
 * 31.从1到n整数中1出现的次数
 *
 * 输入一个整数n,求从1到n这n个整数的十进制表示中1出现的次数.例如输入12,这些整数中包含1的数字有1,10,11,12,1一共出现了5次.
 *
 * @author Jeffrey
 * @since 2018/04/11 10:41
 */
public class CountOne {

    public long countOne(long n) {
        long count = 0;
        long i = 1;
        long current = 0, after = 0, before = 0;
        while ((n / i) != 0) {
            current = (n / i) % 10; // 当前位数字
            before = n / (i * 10); // 高位数字
            after = n - (n / i) * i; // 低位数字
            if (current > 1) {
                count = count + (before + 1) * i;
            } else if (current == 0) {
                count = count + before * i;
            } else if (current == 1) {
                count = count + before * i + after + 1;
            }
            i = i * 10;
        }
        return count;
    }

    @Test
    public void test() {
        Assert.assertEquals(1, countOne(1L));
        Assert.assertEquals(1, countOne(5L));
        Assert.assertEquals(2, countOne(10L));
        Assert.assertEquals(16, countOne(55L));
        Assert.assertEquals(20, countOne(99L));
        Assert.assertEquals(4001, countOne(10000L));
        Assert.assertEquals(18821, countOne(21345L));
        Assert.assertEquals(0, countOne(0L));
    }
}
