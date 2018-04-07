package com.github.ji4597056.chapter_14;

import com.github.ji4597056.common.ListNode;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Test;

/**
 * 14.链表中倒数第k个结点
 *
 * 输入一个链表,输出该链表中倒数第k个结点.为了符合大多数人的习惯,本题从1开始计数,即链表的尾结点是倒数第一个结点.例如一个有6个结点的链表,从头结点依次是1,2,3,4,5,6.倒数第三个结点就是值为4的结点.
 *
 * @author Jeffrey
 * @since 2018/04/07 12:54
 */
public class FindKToTail {

    public <T> ListNode<T> findKToTail(ListNode<T> head, int k) throws Exception {
        if (k <= 0 || head == null) {
            throw new Exception("链表不能为空且k必须大于0!");
        }
        // 两个指针不同速度遍历
        ListNode<T> traverse = head;
        ListNode<T> result = head;
        while (--k > 0) {
            traverse = Optional.ofNullable(traverse.getNext())
                .orElseThrow(() -> new Exception("k不能大于链表长度!"));
        }
        while ((traverse = traverse.getNext()) != null) {
            result = result.getNext();
        }
        return result;
    }

    @Test
    public void test() throws Exception {
        ListNode<Integer> n1 = new ListNode<>(1);
        Assert.assertEquals(n1, findKToTail(n1, 1));
        ListNode<Integer> n2 = new ListNode<>(2);
        ListNode<Integer> n3 = new ListNode<>(3);
        ListNode<Integer> n4 = new ListNode<>(4);
        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        Assert.assertEquals(n2, findKToTail(n1, 3));
    }
}
