package daily;

import java.util.function.IntConsumer;

public class T1116 {
    class ZeroEvenOdd {
        /** 全局信号量，非条件让出线程 */
        private volatile int flag = 0;

        private int n;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; ) {
                if(flag == 0) {
                    printNumber.accept(0);

                    if((i&1)==1){
                        flag = 1;
                    } else {
                        flag = 2;
                    }
                    i++;
                } else {
                    Thread.yield();
                }
            }

        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for(int i=2; i<=n; ) {
                if(flag==2) {
                    printNumber.accept(i);
                    flag = 0;
                    i+=2;
                } else {
                    Thread.yield();
                }
            }

        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for(int i=1; i<=n;) {
                if(flag==1) {
                    printNumber.accept(i);
                    flag = 0;
                    i+=2;
                } else {
                    Thread.yield();
                }
            }
        }
    }
}
