package com.github.ji4597056.chapter_01;

/**
 * 1.实现单例模式
 *
 * 4)懒汉模式
 *
 * @author Jeffrey
 * @since 2018/04/06 17:11
 */
public class SingletonClass4 {

    private static final SingletonClass4 INSTANCE = new SingletonClass4();

    private SingletonClass4() {

    }

    public static SingletonClass4 getInstance() {
        return INSTANCE;
    }
}
