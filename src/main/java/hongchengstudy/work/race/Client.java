package hongchengstudy.work.race;

/*
2、自己编写多线程程序，实现龟兔赛跑的场景.输出格式如下：
兔子跑了1米了，距离终点还剩99米
兔子跑了2米了，距离终点还剩98米
兔子跑了3米了，距离终点还剩97米
乌龟跑了1米了，距离终点还剩99米
 */
public class Client {
    public static Object o = new Object();

    public static void main(String[] args) {
        new Thread(new Rabbit("兔子")).start();
        new Thread(new Tortoise("乌龟")).start();
    }
}

class Rabbit implements Runnable {
    private Integer trackLength = 100;
    private String name;

    public Rabbit(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (Client.o) {
            for (int i = 1; i <= 100; i++) {
                if (i == 100) {
                    System.out.println(this.name + "已经跑到终点");
                    System.out.println("=============游戏结束=========");
                }else{
                    if (i % 3 == 0) {
                        System.out.println(this.name + "已经跑了" + i + "米" + ","+"还剩" + (trackLength - i)+"米");
                        Client.o.notifyAll();
                        try {
                            Client.o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println(this.name + "已经跑了" + i + "米" + ","+"还剩" + (trackLength - i)+"米");
                    }
                }
            }
        }
    }
}

class Tortoise implements Runnable {
    private Integer trackLength = 100;
    private String name;

    public Tortoise(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        synchronized (Client.o) {
            for (int i = 1; i < 100; i++) {
                System.out.println(this.name + "已经跑了" + i + "米" + ","+"还剩" + (trackLength - i)+"米");
                Client.o.notifyAll();
                try {
                    Client.o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}