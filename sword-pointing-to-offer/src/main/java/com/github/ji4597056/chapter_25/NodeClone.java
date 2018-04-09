package com.github.ji4597056.chapter_25;

import com.github.ji4597056.common.ComplexListNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 25.复杂链表的复制
 *
 * 实现函数复制一个复杂链表.在复杂链表中,每个结点除了有一个next指针指向下一个结点外,还有一个指向链表中任意结点或null.
 *
 * @author Jeffrey
 * @since 2018/04/09 16:25
 */
public class NodeClone {

    public ComplexListNode clone(ComplexListNode head) {
        if (head == null) {
            return null;
        }
        // 创建clone节点,链接
        // A->A'->B->B'->C->C'
        ComplexListNode traverse = head;
        while (traverse != null) {
            ComplexListNode next = traverse.getNext();
            ComplexListNode clone = new ComplexListNode(traverse.getValue());
            clone.setNext(next);
            traverse.setNext(clone);
            traverse = next;
        }
        // 设置clone节点的sibling节点
        traverse = head;
        while (traverse != null) {
            ComplexListNode sibling = traverse.getSibling();
            ComplexListNode next = traverse.getNext();
            next.setSibling(sibling == null ? null : sibling.getNext());
            traverse = next.getNext();
        }
        // 拆分成两个链表
        traverse = head;
        ComplexListNode result = traverse.getNext();
        while (traverse != null) {
            traverse.setNext(traverse.getNext().getNext());
            traverse = traverse.getNext();
        }
        return result;
    }

    @Test
    public void test() {
        ComplexListNode root = new ComplexListNode(1);
        ComplexListNode node1 = new ComplexListNode(1);
        ComplexListNode node2 = new ComplexListNode(2);
        ComplexListNode node3 = new ComplexListNode(3);
        ComplexListNode node4 = new ComplexListNode(4);
        root.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        root.setSibling(node1);
        node1.setSibling(root);
        node3.setSibling(node1);

        ComplexListNode clone = clone(root);
        Assert.assertNotSame(clone, root);
        ComplexListNode.traverse(root);
        System.out.println("=============");
        ComplexListNode.traverse(clone);
    }
}
