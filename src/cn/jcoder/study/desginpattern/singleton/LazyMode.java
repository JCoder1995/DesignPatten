package cn.jcoder.study.desginpattern.singleton;

/**
 * 是否 Lazy 初始化：是
 * 是否多线程安全：否
 * 种方式是最基本的实现方式，这种实现最大的问题就是不支持多线程。因为没有加锁 synchronized，所以严格意义上它并不算单例模式。
 * 这种方式 lazy loading 很明显，不要求线程安全，在多线程不能正常工作。
 */
public class LazyMode {

    private static LazyMode instance;

    public LazyMode() {
    }

    public static LazyMode getInstance() {
        if (instance == null) {
            instance = new LazyMode();
        }
        return instance;
    }
}
