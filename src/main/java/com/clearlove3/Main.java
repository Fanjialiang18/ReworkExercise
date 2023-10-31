package com.clearlove3;

/**
 * @author clearlove3
 * @date 2023/10/31 10:24
 */
public class Main {
    public static void main(String[] args) {
        PcPlayService pcPlayService = (PcPlayService) CglibProxyFactory.getProxy(PcPlayService.class);
        pcPlayService.play("Apex Legends");
    }
}