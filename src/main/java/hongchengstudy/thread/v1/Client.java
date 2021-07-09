package hongchengstudy.thread.v1;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Client {
    public static void main(String[] args) {
        Thread.currentThread();
        FutureTask futureTask = new FutureTask<>(new Callable<Runnable>() {
            @Override
            public Runnable call() throws Exception {
                for (int i = 0; i < 100; i++) {
                    System.out.println(i);
                }
                return null;
            }
        });
        System.out.println(ClassLayout.parseInstance(new Thread()).toPrintable());
    }
}
