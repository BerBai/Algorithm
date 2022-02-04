import java.util.concurrent.CountDownLatch;

class FooBar {
    /** 会超出时限要求 */

    /** 信号量标志方法 */
    private volatile boolean flag = false;

    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(flag);
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            flag = !flag;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(!flag);
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            flag = !flag;
        }
    }
}

class FooBar_method2 {
    /**  */

    private CountDownLatch foo = new CountDownLatch(0);
    private CountDownLatch bar = new CountDownLatch(1);
    private int n;

    public FooBar_method2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            foo.await();
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
        }
    }
}