package com.clearlove3;

import java.util.HashMap;
import java.util.HashSet;

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
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(1,1);
        map.put(1,1);
        for (Integer i : set) {
            if(i==1){
                set.remove(i);
            }
        }
    }
}
