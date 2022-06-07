/**
 * synchronized(*.class)代码块 --- 静态同步synchronized方法
 * 同步synchronized(*.class)代码块的作用其实和synchronized static方法作用一样。
 * Class锁对类的所有对象实例起作用。
 */
public class SynchronizedClass {
    public void methodA() {
        try {
            synchronized (SynchronizedClass.class) {
                System.out.println("class methodA 线程名称:" + Thread.currentThread().getName() + " begin times:" + System.currentTimeMillis());
                for (int i = 1; i <= 5; i++) {
                    System.out.println("class methodA 线程名称:" + Thread.currentThread().getName() + "-->i=" + i);
                    Thread.sleep(1000);
                }
                System.out.println("class methodA 线程名称:" + Thread.currentThread().getName() + " end   times:" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void methodB() {
        synchronized (SynchronizedClass.class) {
            System.out.println("class methodB 线程名称:" + Thread.currentThread().getName() + " begin times:" + System.currentTimeMillis());
            System.out.println("class methodB 线程名称:" + Thread.currentThread().getName() + " end   times:" + System.currentTimeMillis());
        }
    }
}

class ClassThreadA extends Thread {
    private SynchronizedClass objectService;

    public ClassThreadA(SynchronizedClass objectService) {
        super();
        this.objectService = objectService;
    }

    @Override
    public void run() {
        objectService.methodA();
    }
}

class ClassThreadB extends Thread {
    private SynchronizedClass objectService;

    public ClassThreadB(SynchronizedClass objectService) {
        super();
        this.objectService = objectService;
    }

    @Override
    public void run() {
        objectService.methodB();
    }
}

// 测试共同对象
class ClassMainTest {
    public static void main(String[] args) {
        SynchronizedClass service = new SynchronizedClass();
        ClassThreadA a = new ClassThreadA(service);
        a.setName("ThreadA");
        a.start();
        ClassThreadB b = new ClassThreadB(service);
        b.setName("ThreadB");
        b.start();
    }
}

// 测试不同对象  ---  Class锁对类的所有对象实例起作用。
class ClassMainTest2 {
    public static void main(String[] args) {
        SynchronizedClass service1 = new SynchronizedClass();
        SynchronizedClass service2 = new SynchronizedClass();
        ClassThreadA a = new ClassThreadA(service1);
        a.setName("ThreadA-service1");
        a.start();
        ClassThreadB b = new ClassThreadB(service2);
        b.setName("ThreadB-service2");
        b.start();
    }
}