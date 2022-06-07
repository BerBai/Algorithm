/**
 * synchronized(this) 只能锁当前对象
 * synchronized(A.class) 锁类，对类的所有实例生效
 */

public class Synchronized {
    public void method1() { // 锁当前对象
        try {
            synchronized (this) {
                System.out.println("this   method1 start time=" + System.currentTimeMillis());
                Thread.sleep(2000);
                System.out.println("this   method1 end time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void method2() { // 与method1存在竞争关系
        System.out.println("       method2 start time=" + System.currentTimeMillis());
        System.out.println("       method2 end time=" + System.currentTimeMillis());
    }

    public void method3() { // 锁类，对类的所有实例生效
        synchronized (Synchronized.class) {
            try {
                System.out.println("class  method3 start time=" + System.currentTimeMillis());
                Thread.sleep(4000);
                System.out.println("class  method3 end time=" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static synchronized void method4() { // 与method3存在竞争关系
        System.out.println("static method4 start time=" + System.currentTimeMillis());
        System.out.println("static method4 end time=" + System.currentTimeMillis());
    }

}

class Thread1 extends Thread {
    private Synchronized objectService;

    public Thread1(Synchronized objectService) {
        super();
        this.objectService = objectService;
    }

    @Override
    public void run() {
        super.run();
        objectService.method1();
    }
}

class Thread2 extends Thread {
    private Synchronized objectService;

    public Thread2(Synchronized objectService) {
        super();
        this.objectService = objectService;
    }

    @Override
    public void run() {
        super.run();
        objectService.method2();
    }
}

class Thread3 extends Thread {
    private Synchronized objectService;

    public Thread3(Synchronized objectService) {
        super();
        this.objectService = objectService;
    }

    @Override
    public void run() {
        super.run();
        objectService.method3();
    }
}

class Thread4 extends Thread {
    private Synchronized objectService;

    public Thread4(Synchronized objectService) {
        super();
        this.objectService = objectService;
    }

    @Override
    public void run() {
        super.run();
        objectService.method4();
    }
}

class MainTest {
    public static void main(String[] args) {
        Synchronized service = new Synchronized();

        new Thread1(service).start();
        new Thread2(service).start();
        new Thread3(service).start();
        new Thread4(service).start();
    }
}

/**
 * 多个线程调用同一个对象中的不同名称的synchronized同步方法或synchronized(this)同步代码块时，是同步的。
 * 1、synchronized同步方法
 * ①对其它的synchronized同步方法或synchronized(this)同步代码块调用是堵塞状态；
 * ②同一时间只有一个线程执行synchronized同步方法中的代码。
 * <p>
 * 2、synchronized(this)同步代码块
 * ①对其它的synchronized同步方法或synchronized(this)同步代码块调用是堵塞状态；
 * ②同一时间只有一个线程执行synchronized同步方法中的代码。
 * 将任意对象作为对象监视器
 */
