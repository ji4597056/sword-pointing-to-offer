package com.github.ji4597056.chapter_34;

import java.util.HashMap;
import java.util.LinkedHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * 34.chapter_34:第一个只出现一次的字符
 *
 * 在字符串中找出第一个只出现一次的字符.如果输入"abaccdeff",则输出'b'.
 *
 * @author Jeffrey
 * @since 2018/05/12 9:00
 */
public class FirstNotRepeatingChar {

    public Character firstNotRepeatChar(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        str.chars().forEach(value -> {
            Character ch = (char) value;
            if (map.containsKey(ch)) {
                map.put(ch, 0);
            } else {
                map.put(ch, 1);
            }
        });
        return map.keySet().stream().filter(ch -> map.get(ch) == 1).findFirst().orElse(null);
    }

    @Test
    public void test() {
        Assert.assertEquals(Character.valueOf('b'), firstNotRepeatChar("abaccdeff"));
        Assert.assertEquals(Character.valueOf('d'), firstNotRepeatChar("abbaccdeff"));
        Assert.assertNull(firstNotRepeatChar("abbaccdeedff"));
    }
}
