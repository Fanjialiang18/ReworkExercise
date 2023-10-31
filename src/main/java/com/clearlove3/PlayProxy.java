package com.clearlove3;

/**
 * @author clearlove3
 * @date 2023/10/31 9:32
 */
public class PlayProxy implements PlayService{

    private final PlayService playService;

    public PlayProxy(PlayService playService) {
        this.playService = playService;
    }

    @Override
    public String play(String s) {
        System.out.println("eat first");
        playService.play(s);
        System.out.println("sleep last");
        return null;
    }

    public static void main(String[] args) {
        PlayService playService = new PlayServiceImpl();
        PlayProxy proxy = new PlayProxy(playService);
        proxy.play("Apex Legends");
    }
}
