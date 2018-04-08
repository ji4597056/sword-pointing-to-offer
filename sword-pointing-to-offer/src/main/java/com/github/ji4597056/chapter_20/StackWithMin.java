package com.github.ji4597056.chapter_20;

import java.util.Stack;
import org.junit.Assert;
import org.junit.Test;

/**
 * 20.包含min函数的栈
 *
 * 定义栈的数据结构,请在该类型中实现一个能够得到栈的最小元素的min函数.在该栈中,调用min、push及pop德尔时间复杂度都是O(1).
 *
 * @author Jeffrey
 * @since 2018/04/08 13:42
 */
public class StackWithMin {

    // 最小值栈
    private Stack<Integer> minStack = new Stack<>();

    // 数据栈
    private Stack<Integer> dataStack = new Stack<>();

    // 入栈
    public void push(Integer data) {
        dataStack.push(data);
        if (minStack.isEmpty() || data <= minStack.peek()) {
            minStack.push(data);
        } else {
            minStack.push(minStack.peek());
        }
    }

    // 出栈
    public Integer pop() {
        if (dataStack.isEmpty() || minStack.isEmpty()) {
            return null;
        }
        minStack.pop();
        return dataStack.pop();
    }

    // 最小值
    public Integer min() {
        return minStack.isEmpty() ? null : minStack.peek();
    }

    @Test
    public void test() {
        push(1);
        push(2);
        push(3);
        Assert.assertEquals(Integer.valueOf(1), min());
        Assert.assertEquals(Integer.valueOf(3), pop());
        Assert.assertEquals(Integer.valueOf(1), min());
        Assert.assertEquals(Integer.valueOf(2), pop());
    }
}
