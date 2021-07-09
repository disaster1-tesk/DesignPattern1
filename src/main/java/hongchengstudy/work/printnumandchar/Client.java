package hongchengstudy.work.printnumandchar;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Object obj = new Object();
        Number number = new Number(obj);
        Chars chars = new Chars(obj);
        Thread th1 = new Thread(number);
        Thread th2 = new Thread(chars);
        th1.start();
        th2.start();
    }
}
//打印数字的线程
class Number implements Runnable{
    private Object obj;
    public Number(Object obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized(obj){
            for(int i = 1;i < 53;i++ ){
                System.out.print(i);
                if(i % 2 == 0){
                    obj.notifyAll();//唤醒打印字符串线程
                    try {
                        obj.wait();//打印数字的线程释放Object对象
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
//打印字符串的线程
class Chars implements Runnable{
    private Object obj;
    public Chars(Object obj){
        this.obj = obj;
    }

    @Override
    public void run() {
        synchronized(obj){
            for(int i = 0;i < 26;i++ ){
                if (i==25){
                    System.out.print((char)(i+'A'));
                }else{
                    System.out.print((char)(i+'A')+",");
                }
                obj.notifyAll();//唤醒打印数字的线程
                try {
                    obj.wait();//释放Object的锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}