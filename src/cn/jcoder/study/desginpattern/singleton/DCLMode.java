package cn.jcoder.study.desginpattern.singleton;

import java.io.Serializable;

/**
 * 双重校验锁( double-checked locking)
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * 这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 * getInstance() 的性能对应用程序很关键。
 */
public class DCLMode implements Serializable {

    //volatile 内存可见 禁止指令重排 不保证原子性
    private volatile static DCLMode dclMode;

    //防止反射，修改私有构造
    public DCLMode() {
        if (dclMode != null) {
            throw new RuntimeException();
        }

    }

    public static DCLMode getDCLMode() {

        if (dclMode == null) {
            synchronized (DCLMode.class) {
                if (dclMode == null) {
                    dclMode = new DCLMode();
                }
            }
        }

        return dclMode;
    }

    private Object readResolve() {
        return dclMode;
    }
}
