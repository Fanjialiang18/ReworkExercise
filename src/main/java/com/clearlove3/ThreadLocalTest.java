package com.clearlove3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author clearlove3
 * @date 2023/11/6 13:29
 */
public class ThreadLocalTest implements Runnable{

    // 每个线程的私有变量
    private static final ThreadLocal<List<Long>> LOCAL = ThreadLocal.withInitial(ArrayList::new);
    private static final ThreadLocal<List<Long>> LOCAL2 = ThreadLocal.withInitial(ArrayList::new);

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest test = new ThreadLocalTest();
        // 运行10个线程
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(test, ""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }
    }

    @Override
    public void run() {
        System.out.println("线程名:" + Thread.currentThread().getName() + "列表1起初为:" + LOCAL.get());
        System.out.println("线程名:" + Thread.currentThread().getName() + "列表2起初为:" + LOCAL2.get());
        try {
            Thread.sleep(new Random().nextInt(1000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        // 修改当前线程的ThreadLocal，但是其余线程的不会被影响
        LOCAL.set(List.of(System.currentTimeMillis()));
        System.out.println("线程名:" + Thread.currentThread().getName() + "列表1结束为:" + LOCAL.get());
        System.out.println("线程名:" + Thread.currentThread().getName() + "列表2结束为:" + LOCAL2.get());
    }
}
