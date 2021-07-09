package com.Reference;

public class M {
    private String name;
    private int age;

    @Override
    protected void finalize() throws Throwable {
        System.out.println("M被回收了！");
    }
}
