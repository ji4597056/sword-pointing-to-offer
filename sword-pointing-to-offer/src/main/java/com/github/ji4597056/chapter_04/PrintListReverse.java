package com.github.ji4597056.chapter_04;

import com.github.ji4597056.common.ListNode;
import java.util.Stack;
import org.junit.Test;

/**
 * 4.从尾到头打印链表
 *
 * 输入一个链表的头结点,从尾到头反过来打印出每个结点的值.
 *
 * @author Jeffrey
 * @since 2018/04/05 18:10
 */
public class PrintListReverse {

    // 递归实现
    public <T> void printListReverse1(ListNode<T> node) {
        if (node == null) {
            return;
        }
        printListReverse1(node.getNext());
        System.out.println(node.getValue());
    }

    // 非递归实现
    public <T> void printListReverse2(ListNode<T> node) {
        Stack<ListNode> stack = new Stack<>();
        ListNode<T> current = node;
        while (current != null) {
            stack.push(current);
            current = current.getNext();
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().getValue());
        }
    }

    @Test
    public void test() {
        ListNode<Integer> n1 = new ListNode<>(1);
        ListNode<Integer> n2 = new ListNode<>(2);
        ListNode<Integer> n3 = new ListNode<>(3);
        ListNode<Integer> n4 = new ListNode<>(4);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        printListReverse1(n1);
        System.out.println("===============");
        printListReverse2(n1);
    }
}
