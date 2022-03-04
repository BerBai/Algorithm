import java.util.concurrent.CountDownLatch;

class Foo {
    /** 信号灯法 设置一个全局标志量 */
    private volatile int flag = 1;

    public Foo() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        while(flag != 1);
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        flag = 2;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        while(flag != 2);
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        flag = 3;
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        while(flag != 3);
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}


class Foo_method2 {
    /** CountDownLatch方式 */
    private CountDownLatch second = new CountDownLatch(1);
    private CountDownLatch third = new CountDownLatch(1);

    public Foo_method2() {
        
    }

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        second.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        second.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        third.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        third.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}