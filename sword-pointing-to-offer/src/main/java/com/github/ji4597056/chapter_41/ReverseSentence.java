package com.github.ji4597056.chapter_41;

import org.junit.Assert;
import org.junit.Test;

/**
 * 41.翻转单词顺序VS左旋转字符串
 *
 * 输入一个英文句子,翻转句子中单词的顺序,但单词内字符的顺序不变.为简单起见,标点符号和普通字母一样处理.例如输入字符串"I am a student.",则输出"student. a am I".
 *
 * @author Jeffrey
 * @since 2018/05/14 9:58
 */
public class ReverseSentence {

    public String reverseSentence(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return sentence;
        }
        char[] chars = sentence.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        // 整体旋转
        reverse(chars, i, j);
        // 局部单词旋转
        for (int p = 0, q = 0, len = chars.length; p < len; p++) {
            if (chars[p] == ' ') {
                reverse(chars, q, p - 1);
                q = p + 1;
            }
        }
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
        Assert.assertEquals("student. a am I", reverseSentence("I am a student."));
        Assert.assertEquals("student. a am I ", reverseSentence(" I am a student."));
    }
}
