package advance.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by l19713 on 2020/9/21.
 */
public class VolatileTest {

//     volatile int number = 0;
    int number = 0;
    /**
     * volatile具可见性实验：不加volatile时，线程AAA修改了number值，由于不可见，main线程读到的number值一直为0，因此线程BBB执行不到，
     * 添加volatile后，volatile通过内存屏障和禁止指令重排序来保证内存可见性，一个线程对volatile变量的修改，能够立刻被其他线程所见，
     * while后的代码顺利执行
     *
     */
    public void visibility() {
        new Thread(() -> {
            System.out.println("Thread " + Thread.currentThread().getName() + "\t come in ...");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            number = 60;
            System.out.println("Thread " + Thread.currentThread().getName() + "\t updated number to " + number);
        }, "AAA").start();

        while (number == 0) {
            System.out.println("Thread " + Thread.currentThread().getName());
        }
        new Thread(() -> {
            System.out.println("Thread " + Thread.currentThread().getName() + "\t come in ...");
        }, "BBB").start();

    }

    /**
     * volatile不具原子性实验：输出number应该为2000，但结果绝大多数情况下<2000
     *
     * 原因：出现丢失写值/覆盖的情况
     */
    public void noneAtomicity() {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    number ++;
                }
            }, String.valueOf(i)).start();
        }
        // 解析下为什么是2，Java运行中至少有两个线程：一个main，一个垃圾回收
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t finally number value: " + number);
    }

    public static void main(String[] args) {
        VolatileTest test = new VolatileTest();
//        test.noneAtomicity();
        test.visibility();
    }
}
