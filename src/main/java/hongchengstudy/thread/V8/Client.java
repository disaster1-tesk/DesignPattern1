package hongchengstudy.thread.V8;

public class Client {
    public static void main(String[] args) {
        Object o = new Object();
        synchronized (o){
            try {
                o.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
