package com.Volatile;


public class VolatileDemo2 {
    private volatile static VolatileDemo2 Mvolatile=null;
    public static VolatileDemo2 getInstance() {
        if (Mvolatile == null) {
            synchronized (VolatileDemo2.class) {
                if (Mvolatile == null) {
                    Mvolatile = new VolatileDemo2();
                }
            }
        }
        return Mvolatile;
    }

    public static void main(String[] args) {
    }
}
