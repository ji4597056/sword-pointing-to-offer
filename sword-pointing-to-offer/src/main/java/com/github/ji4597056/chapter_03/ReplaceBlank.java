package com.github.ji4597056.chapter_03;

import org.junit.Assert;
import org.junit.Test;

/**
 * 3.替换空格
 *
 * 请实现一个函数,把字符串中的每个空格替换成"%20".
 *
 * 注:原题是考数组尾遍历复制的思想
 *
 * @author Jeffrey
 * @since 2018/04/05 17:37
 */
public class ReplaceBlank {

    public String replaceBlank(String input) {
        if (input == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder(input.length());
        input.chars().forEach(ch -> {
            if ((char) ch == ' ') {
                sb.append("%20");
            } else {
                sb.append((char) ch);
            }
        });
        return sb.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals(replaceBlank("123 456"), "123%20456");
        Assert.assertEquals(replaceBlank(" 1 "), "%201%20");
    }
}
