package com.github.ji4597056.chapter_15;

import com.github.ji4597056.common.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 15.反转链表
 *
 * 定义一个函数,输入一个链表的头结点,反转该链表并输出反转后链表的头结点.
 *
 * @author Jeffrey
 * @since 2018/04/07 13:18
 */
public class ReverseList {

    public <T> ListNode<T> reverseList(ListNode<T> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode<T> before = null;
        ListNode<T> traverse = head;
        ListNode<T> after = head.getNext();
        while (after != null) {
            traverse.setNext(before);
            before = traverse;
            traverse = after;
            after = after.getNext();
        }
        traverse.setNext(before);
        return traverse;
    }

    @Test
    public void test() {
        ListNode<Integer> n1 = new ListNode<>(1);
        ListNode<Integer> n2 = new ListNode<>(2);
        ListNode<Integer> n3 = new ListNode<>(3);
        n1.setNext(n2);
        n2.setNext(n3);
        ListNode<Integer> reverse = reverseList(n1);
        ListNode.traverse(reverse);
        Assert.assertEquals(reverse, n3);
    }
}
