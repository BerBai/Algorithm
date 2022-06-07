/**
 * 静态同步synchronized方法 --- synchronized(*.class)代码块
 * synchronized应用在static方法上，那是对当前对应的*.Class进行持锁。
 */
public class SynchronizedStatic {
    public synchronized static void methodA() {
        try {
            System.out.println("static methodA 线程名称:" + Thread.currentThread().getName() + " begin times:" + System.currentTimeMillis());
            for (int i = 1; i <= 5; i++) {
                System.out.println("static methodA 线程名称:" + Thread.currentThread().getName() + "-->i=" + i);
                Thread.sleep(1000);
            }
            System.out.println("static methodA 线程名称:" + Thread.currentThread().getName() + " end   times:" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void methodB() {
        System.out.println("static methodB 线程名称:" + Thread.currentThread().getName() + " begin times:" + System.currentTimeMillis());
        System.out.println("static methodB 线程名称:" + Thread.currentThread().getName() + " end   times:" + System.currentTimeMillis());
    }
}

class StaticThreadA extends Thread {
    @Override
    public void run() {
        SynchronizedStatic.methodA();
    }
}

class StaticThreadB extends Thread {
    @Override
    public void run() {
        SynchronizedStatic.methodB();
    }
}

class StaticMainTest {
    public static void main(String[] args) {
        StaticThreadA a = new StaticThreadA();
        a.setName("ThreadA");
        a.start();
        StaticThreadB b = new StaticThreadB();
        b.setName("ThreadB");
        b.start();
    }
}