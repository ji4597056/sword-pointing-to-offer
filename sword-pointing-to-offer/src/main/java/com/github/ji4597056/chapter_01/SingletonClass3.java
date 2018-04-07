package com.github.ji4597056.chapter_01;

/**
 * 1.实现单例模式
 *
 * 3)静态内部类
 *
 * @author Jeffrey
 * @since 2018/04/05 15:49
 */
public class SingletonClass3 {

    private SingletonClass3() {

    }

    public static SingletonClass3 getInstance() {
        return HolderClass.INSTANCE;
    }

    // 利用了classloder机制来保证初始化INSTANCE时只有一个线程
    private static class HolderClass {

        private static final SingletonClass3 INSTANCE = new SingletonClass3();
    }
}
