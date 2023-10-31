package com.clearlove3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author clearlove3
 * @date 2023/10/31 9:50
 */
public class PlayInvocationHandler implements InvocationHandler {

    private final Object target;

    public PlayInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("eat first");
        Object result = method.invoke(target, args);
        System.out.println("sleep last");
        return result;
    }

    public static void main(String[] args) {
        PlayService playService = (PlayService) JDKProxyFactory.getProxy(new PlayServiceImpl());
        playService.play("Apex Legends");
    }
}
