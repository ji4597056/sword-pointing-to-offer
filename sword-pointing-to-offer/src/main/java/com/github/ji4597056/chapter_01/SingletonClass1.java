package com.github.ji4597056.chapter_01;

/**
 * 1.实现单例模式
 *
 * 1)饿汉模式
 *
 * @author Jeffrey
 * @since 2018/04/05 15:35
 */
public class SingletonClass1 {

    private static final SingletonClass1 SINGLETON_CLASS_1 = new SingletonClass1();

    private SingletonClass1() {
    }

    public static SingletonClass1 getInstance() {
        return SINGLETON_CLASS_1;
    }
}
