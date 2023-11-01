package com.clearlove3;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.function.BiFunction;

/**
 * @author clearlove3
 * @date 2023/10/31 17:00
 */
public class CollectionsTest {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);
        // 具有fail-fast机制的集合在for each里只能用iterator的remove/add方法
        // JUC的包是fail-safe的
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            if(next == 3){
                iterator.remove();
            }else {
                System.out.println(next);
            }
        }
        // JUC的可以在for each里直接删除
        ConcurrentLinkedDeque<Integer> deque = new ConcurrentLinkedDeque<>();
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        for (Integer i : deque) {
            if(i==2){
                deque.remove(i);
            }else {
                System.out.println(i);
            }
        }


        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(1,1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(null);
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();
        System.out.println(synchronousQueue.offer(1));
        ConcurrentHashMap<Integer, Integer> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.putIfAbsent(1,2);
        concurrentHashMap.put(1,concurrentHashMap.get(1)+1);
        // 等同上一句
        concurrentHashMap.compute(1,(key,value)->value+1);
        System.out.println(concurrentHashMap);

    }
}
