/**
 * 单例模式的特点：
 * 首先，单例模式使类在程序生命周期的任何时刻都只有一个实例，
 * 然后，单例的构造函数是私有的，外部程序如果想要访问这个单例类的话，必须通过getInstance()来请求（注意是请求）得到这个单例类的实例。
 */
public class Singleton {
    private volatile static Singleton singleton;

    private Singleton() {
    }

    private static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

/**
 * 1.为什么要用判断双重?
 * 因为可能有两个线程都执行完了第一个if语句，如果没有第二重判断，那么当其中有个线程执行完synchronized里面的语句之后，另外一个线程跟着也会执行，这样就达不到单例模式的效果
 * <p>
 * 2.第一重判断去掉也可以实现，为什么不去掉？
 * 单例模式双重检查锁机制 https://qinjiangbo.com/mechanism-of-double-locking-check.html
 * 考虑这样一种情况，就是有两个线程同时到达，即同时调用getInstance()，
 * 此时由于singleton == null，所以很明显，两个线程都可以通过第一重的singleton == null，进入第一重 if 语句后，由于存在锁机制，所以会有一个线程进入 lock 语句并进入第二重 singleton == null ，而另外的一个线程则会在lock语句的外面等待。而当第一个线程执行完 new Singleton()语句后，便会退出锁定区域，此时，第二个线程便可以进入lock语句块，此时，如果没有第二重singleton == null的话，那么第二个线程还是可以调用new Singleton()语句，这样第二个线程也会创建一个Singleton实例，这样也还是违背了单例模式的初衷的，所以这里必须要使用双重检查锁定。
 * 细心的朋友一定会发现，如果我去掉第一重singleton == null，程序还是可以在多线程下完好的运行的，考虑在没有第一重singleton == null的情况下，当有两个线程同时到达，此时，由于lock机制的存在，第一个线程会进入lock语句块，并且可以顺利执行new Singleton()，当第一个线程退出lock语句块时， singleton这个静态变量已不为null了，所以当第二个线程进入lock时，还是会被第二重singleton == null挡在外面，而无法执行new Singleton().
 * 所以在没有第一重singleton == null的情况下，也是可以实现单例模式的。
 * <p>
 * 3. 那么为什么需要第一重singleton == null呢？
 * 这里就涉及一个性能问题了，因为对于单例模式的话，new Singleton()只需要执行一次就 OK 了，而如果没有第一重singleton == null的话，每一次有线程进入getInstance()时，均会执行锁定操作来实现线程同步，这是非常耗费性能的，而如果我加上第一重singleton == null 的话，那么就只有在第一次，也就是singleton ==null成立时的情况下执行一次锁定以实现线程同步，而以后的话，便只要直接返回Singleton实例就 OK 了而根本无需再进入lock语句块了，这样就可以解决由线程同步带来的性能问题了。
 * <p>
 * 参考：单例模式双重检查锁机制 <https://qinjiangbo.com/mechanism-of-double-locking-check.html>
 */


/**
 * 懒汉模式：首次使用单例实例的时候创建，之后使用时再判断单例实例是否已创建，如果没有则创建实例。
 */
class LazySingleton {
    private static LazySingleton instance = null;

    private Singleton() {
    }

    // 饿汉模式需要考虑线程安全问题，因为在使用时创建实例，可能有多个线程同时在调用。以下几种实现
    // 1.效率最高，线程安全
    public static LazySingleton getInstance() {
        // 如果对象为空才进入同步方法块，否则返回实例对象
        if (instance == null) {
            synchronized (LazySingleton.class) {
                // 确保线程安全
                if (instance == null)
                    instance = new LazySingleton();
            }
        }
        return instance;
    }

    // 2.静态synchronized方法 线程安全
    public static synchronized LazySingleton getInstance2() {
        if (instance == null)
            instance = new LazySingleton();
        return instance;
    }

    // 3.synchronized class同步块（每次调用都进入同步块） 线程安全
    public static LazySingleton getInstance3() {
        synchronized (LazySingleton.class) {
            if (instance == null)
                instance = new LazySingleton();
        }
        return instance;
    }

    // 4.不加同步锁 线程不安全
    public static LazySingleton getInstance4() {
        if (instance == null)
            instance = new LazySingleton();
        return instance;
    }


}

/**
 * 饿汉模式：在该类初始化的时候就创建实例对象，线程是安全的。
 */
class HungrySingleton {
    // 不管有没有需求，类初始的时候就创建实例对象
    private static final HungrySingleton instance = new HungrySingleton();

    private Singleton() {
    }

    public static final HungrySingleton getInstance() {
        return instance;
    }
}