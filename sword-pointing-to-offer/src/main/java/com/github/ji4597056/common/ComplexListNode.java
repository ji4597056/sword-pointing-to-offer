package com.github.ji4597056.common;

/**
 * 复杂链表
 *
 * @author Jeffrey
 * @since 2018/04/09 16:15
 */
public class ComplexListNode {

    private int value;

    private ComplexListNode next;

    private ComplexListNode sibling;

    public static void traverse(ComplexListNode head) {
        ComplexListNode traverse = head;
        while (traverse != null) {
            System.out.println("value:" + traverse.value + ",sibling:" + traverse.sibling);
            traverse = traverse.getNext();
        }
    }

    public ComplexListNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ComplexListNode getNext() {
        return next;
    }

    public void setNext(ComplexListNode next) {
        this.next = next;
    }

    public ComplexListNode getSibling() {
        return sibling;
    }

    public void setSibling(ComplexListNode sibling) {
        this.sibling = sibling;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ComplexListNode{");
        sb.append("value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
