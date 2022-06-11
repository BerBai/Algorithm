import java.util.function.Supplier;

/**
 * 当类有字段赋值操作或者静态代码块时，编译后会为这个类生成clinit方法来执行这些语句。
 * clinit方法是被加锁的，同于一时刻只能有一个线程执行某个类的clinit方法。
 */
public class Clinit {
    static class A {
        static {//clinit方法
            if (true) {
                System.out.println(Thread.currentThread() + "init Class A");
                while (true) {
                }
            }
        }

        public static A create(Supplier<A> supplier) {
            return supplier.get();
        }
    }

    public static void main(String[] args) {
//        匿名内部类
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() { // 覆盖重写抽象方法
//                System.out.println(Thread.currentThread()+" start");
//                A a = new A();
//                System.out.println(Thread.currentThread()+" finish");
//            }
//        };

        // lambda表达式 作用同上
        Runnable runnable1 = () -> {
            System.out.println(Thread.currentThread() + " start");
            A a = new A();
            System.out.println(Thread.currentThread() + " finish");
        };

        //两个线程要加载同一个类
        new Thread(runnable1).start();
        new Thread(runnable1).start();
    }

}
