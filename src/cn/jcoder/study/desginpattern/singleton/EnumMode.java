package cn.jcoder.study.desginpattern.singleton;


/**
 * 但这是实现单例模式的最佳方法。它更简洁，自动支持序列化机制，绝对防止多次实例化。
 * 这种方式是 Effective Java 作者 Josh Bloch 提倡的方式，它不仅能避免多线程同步问题，而且还自动支持序列化机制，防止反序列化重新创建新的对象，绝对防止多次实例化。
 */
public class EnumMode {

    //私有构造
    private EnumMode() {
    }

    //私有枚举
    public static EnumMode getInstance() {
        return EnumModeEnum.INSTANCE.getInstance();
    }

    private enum EnumModeEnum {
        INSTANCE;
        private final EnumMode enumMode;

        //JVM 会保证方法只调用一次
        EnumModeEnum() {
            enumMode = new EnumMode();
        }

        public EnumMode getInstance() {
            return enumMode;
        }
    }
}
