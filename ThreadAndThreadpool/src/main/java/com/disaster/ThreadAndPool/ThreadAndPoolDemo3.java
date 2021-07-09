package com.disaster.ThreadAndPool;


import sun.misc.Unsafe;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ThreadAndPoolDemo3 {
    static class M{
        private M(){
        }
        int i=0;
    }
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
       /* Class aClass = Class.forName("jdk.internal.misc.Unsafe");
        long address = 10l;
        Object o = aClass.newInstance();
        Method putAddress = aClass.getDeclaredMethod("getByte");
        putAddress.setAccessible(true);
        // public byte getByte(long address) {
        //        return getByte(null, address);
        //    }
        Object invoke = putAddress.invoke(o, address);
        System.out.println(invoke.toString());*/
        Unsafe unsafe = Unsafe.getUnsafe();
        M m = (M) unsafe.allocateInstance(M.class);
        m.i = 9;
        System.out.println(m.i);
    }
}
