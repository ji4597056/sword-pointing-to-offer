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

    // 将链表遍历用以测试结果
    public static void traverse(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode traverse = head;
        boolean isBeginning = true;
        while (traverse != null) {
            if (isBeginning) {
                isBeginning = false;
                System.out.print(traverse.getValue());
            } else {
                System.out.print("," + traverse.getValue());
            }
            traverse = traverse.getNext();
        }
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
        sb.append('}');
        return sb.toString();
    }
}
