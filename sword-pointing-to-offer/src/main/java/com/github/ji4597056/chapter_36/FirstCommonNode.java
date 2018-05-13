package com.github.ji4597056.chapter_36;

import com.github.ji4597056.common.ListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 36.chapter_36:两个链表的第一个公共结点
 *
 * 输入两个链表,找出它们的第一个公共结点.
 *
 * @author Jeffrey
 * @since 2018/05/12 19:01
 */
public class FirstCommonNode {

    public ListNode findFirstCommonNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        // 避免使用stack或hashmap,减少空间复杂度
        ListNode traverse1 = head1;
        ListNode traverse2 = head2;
        int size1 = 0;
        int size2 = 0;
        while (traverse1 != null) {
            size1++;
            traverse1 = traverse1.getNext();
        }
        while (traverse2 != null) {
            size2++;
            traverse2 = traverse2.getNext();
        }
        traverse1 = head1;
        traverse2 = head2;
        while (size1 > size2) {
            traverse1 = traverse1.getNext();
            size1--;
        }
        while (size2 > size1) {
            traverse2 = traverse2.getNext();
            size2--;
        }
        while (traverse1 != null) {
            if (traverse1 == traverse2) {
                return traverse1;
            }
            traverse1 = traverse1.getNext();
            traverse2 = traverse2.getNext();
        }
        return null;
    }

    @Test
    public void test() {
        ListNode<Integer> n1 = new ListNode<>(1);
        ListNode<Integer> n2 = new ListNode<>(2);
        ListNode<Integer> n3 = new ListNode<>(3);
        ListNode<Integer> n4 = new ListNode<>(4);
        ListNode<Integer> n5 = new ListNode<>(5);
        ListNode<Integer> n6 = new ListNode<>(6);
        ListNode<Integer> n7 = new ListNode<>(7);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n6);
        n6.setNext(n7);
        n4.setNext(n5);
        n5.setNext(n6);
        Assert.assertEquals(n6, findFirstCommonNode(n1, n4));
    }
}
