package com.github.ji4597056.chapter_06;

import java.util.Stack;
import java.util.stream.IntStream;
import org.junit.Test;

/**
 * @author Jeffrey
 * @since 2018/04/06 12:54
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
