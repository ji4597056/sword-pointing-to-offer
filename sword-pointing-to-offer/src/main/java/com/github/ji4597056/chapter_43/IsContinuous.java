package com.github.ji4597056.chapter_43;

import java.util.Arrays;
import org.junit.Assert;
import org.junit.Test;

/**
 * 43.扑克牌的顺子
 *
 * 从扑克牌中随机抽5张牌,判断是不是顺子,即这5张牌是不是连续的.2-10为数字本身,A为1,J为11,Q为12,K为13,而大小王可以看成任意的数字.
 *
 * @author Jeffrey
 * @since 2018/05/28 10:31 AM
 */
public class IsContinuous {

    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length != 5) {
            throw new IllegalArgumentException("numbers's length requires 5!");
        }
        // 先排序,大小王为0
        Arrays.sort(numbers);
        int numOfZero = 0;
        int before = 0;
        for (int i = 0; i < 5; i++) {
            if (numbers[i] == 0) {
                numOfZero++;
            } else if (before == 0) {
                before = numbers[i];
            } else {
                numOfZero -= numbers[i] - before - 1;
                if (numbers[i] == before || numOfZero < 0) {
                    return false;
                }
                before = numbers[i];
            }
        }
        return true;
    }

    @Test
    public void test() {
        Assert.assertTrue(isContinuous(new int[]{0, 4, 6, 8, 0}));
        Assert.assertFalse(isContinuous(new int[]{0, 3, 6, 8, 0}));
    }
}
