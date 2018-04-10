package com.github.ji4597056.chapter_27;

import org.junit.Test;

/**
 * 27.字符串的排列
 *
 * 输入一个字符串,打印出该字符串中字符的所有排列.
 *
 * @author Jeffrey
 * @since 2018/04/10 17:20
 */
public class StringPermutation {

    public void permutation(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        permutation(str.toCharArray(), 0, str.length() - 1);
    }

    private void permutation(char[] chars, int start, int end) {
        if (start == end) {
            for (char ch : chars) {
                System.out.print(ch);
            }
            System.out.println();
        } else {
            for (int i = start; i <= end; i++) {
                // 字符去重
                if (!isRepeated(chars, start, i)) {
                    swap(chars, i, start); // 固定第start个字符
                    permutation(chars, start + 1, end); // 从第start+1个字符开始进行全排列
                    swap(chars, i, start); // 复位第start个字符
                }
            }
        }
    }

    private void swap(char[] chars, int m, int n) {
        char temp = chars[m];
        chars[m] = chars[n];
        chars[n] = temp;
    }

    private static boolean isRepeated(char[] chars, int start, int end) {
        for (int i = start; i < end; i++) {
            if (chars[i] == chars[end]) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
        permutation("abc");
        System.out.println("========");
        permutation("a");
        System.out.println("========");
        permutation("aba");
        System.out.println("========");
        permutation("abac");
    }
}
