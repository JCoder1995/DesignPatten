package cn.jcoder.study.desginpattern.singleton;

/**
 * 这种方式能达到双检锁方式一样的功效，但实现更简单。对静态域使用延迟初始化，应使用这种方式而不是双检锁方式。
 * 这种方式只适用于静态域的情况，双检锁方式可在实例域需要延迟初始化时使用。
 * 这种方式同样利用了 classloader 机制来保证初始化 instance 时只有一个线程
 *
 */
public class StaticMode {

    private static class SingletonHolder {
        private static final StaticMode INSTANCE = new StaticMode();
    }

    private StaticMode() {
    }

    public static StaticMode getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
