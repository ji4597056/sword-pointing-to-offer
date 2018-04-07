package com.github.ji4597056.chapter_06;

import java.util.Stack;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * 6.用两个栈实现队列
 *
 * 用两个栈实现一个队列,实现对了的两个函数appendTail和deleteHead,分别完成在队列尾插入结点和在队列头部删除结点的功能.
 *
 * @author Jeffrey
 * @since 2018/04/05 15:30
 */
public class CQueue<T> {

    private Stack<T> stack1 = new Stack<>();

    private Stack<T> stack2 = new Stack<>();

    public void appendTail(T t) {
        stack1.push(t);
    }

    public T deleteHead() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return null;
        }
        return stack2.pop();
    }

    @Test
    public void test() {
        CQueue<Integer> cQueue = new CQueue<>();
        IntStream.range(0, 10).forEach(cQueue::appendTail);
        Integer i;
        while ((i = cQueue.deleteHead()) != null) {
            System.out.print(i + " ");
        }
    }
}
