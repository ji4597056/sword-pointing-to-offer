package com.github.ji4597056.common;

/**
 * 单链表
 *
 * @author Jeffrey
 * @since 2018/04/05 18:07
 */
public class ListNode<T> {

    private T value;

    private ListNode<T> next;

    public ListNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ListNode{");
        sb.append("value=").append(value);
        sb.append(", next=").append(next);
        sb.append('}');
        return sb.toString();
    }
}
