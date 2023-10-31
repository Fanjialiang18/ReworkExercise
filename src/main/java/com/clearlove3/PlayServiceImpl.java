package com.clearlove3;

/**
 * @author clearlove3
 * @date 2023/10/31 9:31
 */
public class PlayServiceImpl implements PlayService{
    @Override
    public String play(String s) {
        System.out.println("Play "+ s + "....");
        return s;
    }
}
