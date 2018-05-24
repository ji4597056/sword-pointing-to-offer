package com.github.ji4597056.chapter_41;

import org.junit.Assert;
import org.junit.Test;

/**
 * 41.翻转单词顺序VS左旋转字符串
 *
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部.请定义一个函数实现字符串左旋转操作的功能.比如输入字符串"abcdefg"和数字2,该函数将返回左旋转2位得到的结果"cdefgab".
 *
 * @author Jeffrey
 * @since 2018/05/14 10:25
 */
public class LeftRotateString {

    public String leftRotateString(String str, int n) {
        if (str == null || n > str.length()) {
            throw new IllegalArgumentException("str is null or error n!");
        }
        char[] chars = str.toCharArray();
        // 反转整体
        reverse(chars, 0, chars.length - 1);
        // 反转局部
        reverse(chars, 0, chars.length - n - 1);
        reverse(chars, chars.length - n, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char ch = chars[start];
            chars[start] = chars[end];
            chars[end] = ch;
            start++;
            end--;
        }
    }

    @Test
    public void test() {
        Assert.assertEquals("cdefgab", leftRotateString("abcdefg", 2));
    }
}
