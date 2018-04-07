package com.github.ji4597056.chapter_12;

import com.github.ji4597056.common.ListNode;
import org.junit.Test;

/**
 * 12.在O(1)时间删除链表结点
 *
 * 给定单向链表的头指针和一个结点指针,定义一个函数在O(1)时间删除该结点.
 *
 * @author Jeffrey
 * @since 2018/04/05 15:30
 */
public class DeleteNode {

    // 前提条件为deListNode确定在链表中,否则仍然需要遍历以确定deListNode是否在链表中
    public <T> void deleteNode(ListNode<T> head, ListNode<T> deListNode) {
        if (deListNode == null || head == null) {
            return;
        }
        if (head == deListNode) {
            // 删除节点为头节点
            head = null;
        } else if (deListNode.getNext() != null) {
            // 删除节点非尾节点
            // 将删除节点的下一个节点的value复制过来,然后删除下一个节点
            deListNode.setValue(deListNode.getNext().getValue());
            deListNode.setNext(deListNode.getNext().getNext());
        } else {
            // 删除节点为尾节点,则需要遍历
            ListNode traverse = head;
            while (traverse.getNext().getNext() != null) {
                traverse = traverse.getNext();
            }
            traverse.setNext(null);
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

        ListNode.traverse(n1);
        System.out.println("\n===========");
        deleteNode(n1, n3);
        ListNode.traverse(n1);
        System.out.println("\n===========");
        deleteNode(n1, n4);
        ListNode.traverse(n1);
        System.out.println("\n===========");
    }
}
