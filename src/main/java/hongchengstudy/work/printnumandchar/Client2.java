package hongchengstudy.work.printnumandchar;

public class Client2 {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        PrintNum printNum = new PrintNum(o);
        PrintChar printChar = new PrintChar(o);
        new Thread(printNum).start();
        Thread.sleep(1);
        new Thread(printChar).start();
    }
}

class PrintNum implements Runnable {
    private Object o = null;

    public PrintNum(Object o) {
        this.o = o;
    }

    @Override
    public void run() {
        for (int i = 1; i < 53; i++) {
            if (i % 2 == 0) {
                synchronized (o) {
                    System.out.print(i);
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                synchronized (o) {
                    System.out.print(i);
                }
            }
        }
    }
}

class PrintChar implements Runnable {
    private Object o = null;

    public PrintChar(Object o) {
        this.o = o;
    }

    @Override
    public void run() {
        for (int i = 0; i < 26; i++) {
            synchronized (o) {
                if (i == 25) {
                    System.out.print((char) (i + 'A'));
                } else {
                    System.out.print((char) (i + 'A') + ",");
                }
            }
            try {
                Thread.sleep(203);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}