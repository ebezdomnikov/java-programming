package com.javarush.task.task32.task3205;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    private SomeInterfaceWithMethods orig;

    public CustomInvocationHandler(SomeInterfaceWithMethods orig) {
        this.orig = orig;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(String.format("[%s in]", method.getName()));
        Object r = method.invoke(orig, args);
        System.out.println(String.format("[%s out]", method.getName()));
        return r;
    }
}
