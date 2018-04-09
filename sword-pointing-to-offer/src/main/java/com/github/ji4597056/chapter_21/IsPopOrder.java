package com.github.ji4597056.chapter_21;

import java.util.Stack;
import org.junit.Assert;
import org.junit.Test;

/**
 * 21.栈的压入、弹出序列
 *
 * 输入两个整数序列,第一个序列表示栈的压入顺序,请判断第二个序列是否为该栈的弹出序列.假设压入栈的所有数字均不相等.例如压栈序列为1、2、3、4、5.序列4、5、3、2、1是压栈序列对应的一个弹出序列,但4、3、5、1、2却不是.
 *
 * @author Jeffrey
 * @since 2018/04/09 9:50
 */
public class IsPopOrder {

    public boolean isPopOrder(int[] line1, int[] line2) {
        if (line1 == null || line2 == null) {
            return false;
        }
        int len1 = line1.length;
        int len2 = line2.length;
        if (len1 != len2) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < len1; i++) {
            stack.push(line1[i]);
            while (!stack.isEmpty() && j < len2 && stack.peek() == line2[j]) {
                j++;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    @Test
    public void test() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {4, 3, 5, 2, 1};
        int[] array3 = {4, 3, 5, 1, 2};
        Assert.assertTrue(isPopOrder(array1, array2));
        Assert.assertFalse(isPopOrder(array1, array3));
    }
}
