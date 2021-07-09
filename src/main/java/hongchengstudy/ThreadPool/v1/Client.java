package hongchengstudy.ThreadPool.v1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
        new Thread(() -> {
            System.out.println("准备");
        });
    }
}
