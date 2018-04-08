package com.github.ji4597056.chapter_16;

import com.github.ji4597056.common.ListNode;
import org.junit.Test;

/**
 * 16.合并两个排序的链表
 *
 * 输入两个递增排序的链表,合并这两个链表并使新链表中的结点仍然是按照递增排序的.
 *
 * @author Jeffrey
 * @since 2018/04/08 9:48
 */
public class MergeList {

    // 递归思路
    public ListNode<Integer> mergeList(ListNode<Integer> head1, ListNode<Integer> head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        if (head1.getValue() < head2.getValue()) {
            head1.setNext(mergeList(head1.getNext(), head2));
            return head1;
        } else {
            head2.setNext(mergeList(head1, head2.getNext()));
            return head2;
        }
    }

    @Test
    public void test() {
        ListNode<Integer> n11 = new ListNode<>(1);
        ListNode<Integer> n12 = new ListNode<>(3);
        ListNode<Integer> n13 = new ListNode<>(6);
        n11.setNext(n12);
        n12.setNext(n13);
        ListNode<Integer> n21 = new ListNode<>(2);
        ListNode<Integer> n22 = new ListNode<>(4);
        ListNode<Integer> n23 = new ListNode<>(5);
        n21.setNext(n22);
        n22.setNext(n23);
        ListNode.traverse(mergeList(n11, n21));
    }
}
