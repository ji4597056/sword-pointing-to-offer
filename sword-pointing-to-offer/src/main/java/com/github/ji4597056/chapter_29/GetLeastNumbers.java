package com.github.ji4597056.chapter_29;

import java.util.PriorityQueue;
import org.junit.Test;

/**
 * 29.最小的k个数
 *
 * 输入n个整数,找出其中最小的k个数.例如输入4,5,1,6,2,7,3,8这8个数字,则最少的4个数字是1,2,3,4.
 *
 * @author Jeffrey
 * @since 2018/04/11 0:07
 */
public class GetLeastNumbers {

    public void getLeastNumbers(int[] array, int k) {
        if (array == null || k <= 0) {
            return;
        }
        if (array.length <= k) {
            for (int i : array) {
                System.out.println(i);
            }
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (v1, v2) -> v2 - v1);
        for (int i : array) {
            if (queue.size() < k) {
                queue.offer(i);
            } else if (queue.peek() > i) {
                queue.poll();
                queue.offer(i);
            }
        }
        Integer i;
        while ((i = queue.poll()) != null) {
            System.out.println(i);
        }
    }

    @Test
    public void test() {
        int[] array = {4, 5, 1, 6, 2, 7, 3, 8};
        getLeastNumbers(array, 3);
        System.out.println("============");
        getLeastNumbers(array, 5);
    }
}
