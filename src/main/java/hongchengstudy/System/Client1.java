package hongchengstudy.System;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.omg.PortableInterceptor.Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Client1 {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Performance.class);
        enhancer.setCallback(new TestPerformanceInterceptor());
        Moveable m1 = (Moveable) enhancer.create();
        m1.move();
        //---------------------------------------
        Moveable m = (Moveable) Proxy.newProxyInstance(Performance.class.getClassLoader(),
                Performance.class.getInterfaces(),
                new TestPerformanceHandler(new Performance())
        );
        m.move();
        //-----------------------------------------
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        long num = 0;
        for (int i = 0; i < 1000000000; i++) {
            num+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println("end = "+end);
        System.out.println("一共耗时："+(end-start));
    }
}
class TestPerformanceHandler implements InvocationHandler {
    Moveable performance;

    public TestPerformanceHandler(Moveable performance) {
        this.performance = performance;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        Object invoke = method.invoke(performance, args);
        long end = System.currentTimeMillis();
        System.out.println("end = "+end);
        System.out.println("一共耗时："+(end-start));
        return invoke;
    }
}
class Performance implements Moveable{
    protected int num;
    @Override
    public void move() {
        for (int i = 0; i < 1000000000; i++) {
            num+=i;
        }
    }
}
interface Moveable{
    void move();
}
class Performance1 implements Moveable{
    protected int num;
    @Override
    public void move() {
        for (int i = 0; i < 1000000000; i++) {
            num+=i;
        }
    }
}
class TestPerformanceInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("start = " + start);
        Object result = methodProxy.invokeSuper(o,objects);
        long end = System.currentTimeMillis();
        System.out.println("end = "+end);
        System.out.println("一共耗时："+(end-start));
        return result;
    }
}