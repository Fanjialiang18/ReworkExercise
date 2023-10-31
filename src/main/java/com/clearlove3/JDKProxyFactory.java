package com.clearlove3;

import java.lang.reflect.Proxy;

/**
 * @author clearlove3
 * @date 2023/10/31 9:51
 */
public class JDKProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new PlayInvocationHandler(target)
        );
    }
}
