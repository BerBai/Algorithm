/**
 * synchronized(this)锁定当前对象
 */

public class SynchronizedThis {
    public void methodA() {
        try {
            synchronized (this) {
                System.out.println("this methodA 线程名称:" + Thread.currentThread().getName() + " begin time=" + System.currentTimeMillis());
                for (int i = 1; i <= 2; i++) {
                    System.out.println("this methodA 线程名称:" + Thread.currentThread().getName() + "-->i=" + i);
                    Thread.sleep(100);
                }
                System.out.println("this methodA 线程名称:" + Thread.currentThread().getName() + " end  time=" + System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void methodB() {
        synchronized (this) {
            try {
                System.out.println("this methodB 线程名称:" + Thread.currentThread().getName() + " begin time=" + System.currentTimeMillis());
                for (int i = 1; i <= 2; i++) {
                    System.out.println("this methodB 线程名称:" + Thread.currentThread().getName() + "-->i=" + i);
                    Thread.sleep(100);
                }
                System.out.println("this methodB 线程名称:" + Thread.currentThread().getName() + " end  time=" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void methodC() {
        try {
            System.out.println("     methodC 线程名称:" + Thread.currentThread().getName() + " begin time=" + System.currentTimeMillis());
            for (int i = 1; i <= 2; i++) {
                System.out.println("     methodC 线程名称:" + Thread.currentThread().getName() + "-->i=" + i);
                Thread.sleep(100);
            }
            System.out.println("     methodC 线程名称:" + Thread.currentThread().getName() + " end  time=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThisThreadA extends Thread {
    private SynchronizedThis synchronizedThis;

    public ThisThreadA(SynchronizedThis synchronizedThis) {
        super();
        this.synchronizedThis = synchronizedThis;
    }

    @Override
    public void run() {
        super.run();
        synchronizedThis.methodA();
    }
}

class ThisThreadB extends Thread {
    private SynchronizedThis synchronizedThis;

    public ThisThreadB(SynchronizedThis synchronizedThis) {
        super();
        this.synchronizedThis = synchronizedThis;
    }

    @Override
    public void run() {
        super.run();
        synchronizedThis.methodB();
    }
}

class ThisThreadC extends Thread {
    private SynchronizedThis synchronizedThis;

    public ThisThreadC(SynchronizedThis synchronizedThis) {
        super();
        this.synchronizedThis = synchronizedThis;
    }

    @Override
    public void run() {
        super.run();
        synchronizedThis.methodC();
    }
}

class ThisMainTest {
    public static void main(String[] args) {
        SynchronizedThis service = new SynchronizedThis();
        ThisThreadA a = new ThisThreadA(service);
        a.setName("ThreadA");
        a.start();
        ThisThreadB b = new ThisThreadB(service);
        b.setName("ThreadB");
        b.start();
        ThisThreadC c = new ThisThreadC(service);
        c.setName("ThreadC");
        c.start();
    }
}