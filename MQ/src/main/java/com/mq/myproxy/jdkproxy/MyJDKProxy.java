package com.mq.myproxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyJDKProxy implements InvocationHandler {

    Object object;

    public MyJDKProxy(Object object) {
        this.object = object;
    }

    public MyJDKProxy() {
    }

    public  Object creatProxyObj(Object object){
            this.object =object;
        return  Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("被代理方法 前置强化");
           Object o =  method.invoke(object,args);
        System.out.println("被代理方法 后置强化");

        return o;
    }
}
