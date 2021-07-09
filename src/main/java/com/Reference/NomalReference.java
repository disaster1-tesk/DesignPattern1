package com.Reference;
/**
 *java中的四大引用：
 *  强、软、弱、虚
 *  强引用：jvm中没有强引用指向的对象会被GC回收
 *  软引用：jvm中如果内存不够会使软引用中指向的对象进行GC回收 （ThreadLocal当中就使用了这种技术）
 *  弱引用：jvm每次进行垃圾回收都会把弱引用收回掉
 *  虚引用：用于管理堆外内存（nio、zerocopy中使用了这种技术）
 */
public class NomalReference {

    public static void main(String[] args) {
        M m = new M();
        m= null;
        System.gc();
        System.out.println(m);
    }
}
