import java.util.concurrent.CountDownLatch;

class FooBar1 {
    /** 使用while会超出时限要求 */
    /** 全局信号量 */
    private volatile boolean flag = true;
    private int n;

    public FooBar1(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(!flag);
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();
            flag = !flag;
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(flag);
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();
            flag = !flag;
        }
    }
}

class FooBar2 {
    /** 基于上述代码的改进，非条件让出线程 */
    /** 全局信号量 */
    private volatile boolean flag = true;

    private int n;

    public FooBar2(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; ) {
            if(flag){
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                flag = !flag;
                i++;
            } else {
                Thread.yield();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; ) {
            if(!flag) {
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                flag = !flag;
                i++;
            } else {
                Thread.yield();
            }
        }
    }
}
