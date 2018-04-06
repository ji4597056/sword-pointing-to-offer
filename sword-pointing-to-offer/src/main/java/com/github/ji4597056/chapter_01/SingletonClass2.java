package com.github.ji4597056.chapter_01;

/**
 * 双重校验锁
 *
 * @author Jeffrey
 * @since 2018/04/05 15:38
 */
public class SingletonClass2 {

    // 之所以yolatile关键字修饰是为了防止指令重排序
    // singletonClass2 = new SingletorClass2()可能会发生指令重排序,现将引用指向对象内存地址,再初始化对象
    // 单线程下这种指令重排序没有问题,但是多线程下可能导致singletonClass2 != null,但是此时得到的对象并未初始化完成
    private volatile static SingletonClass2 singletonClass2;

    private SingletonClass2() {
    }

    public static SingletonClass2 getInstance() {
        if (singletonClass2 == null) {
            synchronized (SingletonClass2.class) {
                if (singletonClass2 == null) {
                    singletonClass2 = new SingletonClass2();
                }
            }
        }
        return singletonClass2;
    }
}
