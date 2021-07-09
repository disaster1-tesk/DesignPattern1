package hongchengstudy.work.cave;

/*
1、自己编写多线程程序，模拟多个人通过一个山洞的场景。
这个山洞每次只能通过一个人，每个人通过山洞的时间为5秒，
有10个人同时准备过此山洞，显示每次通过山洞的人的姓名和顺序。
 */
public class Client {
    public static void main(String[] args) {
        Cave cave = new Cave();
        new Thread(new Person("disaster1",cave)).start();
        new Thread(new Person("disaster2",cave)).start();
        new Thread(new Person("disaster3",cave)).start();
        new Thread(new Person("disaster4",cave)).start();
        new Thread(new Person("disaster5",cave)).start();
        new Thread(new Person("disaster6",cave)).start();
        new Thread(new Person("disaster7",cave)).start();
        new Thread(new Person("disaster8",cave)).start();
        new Thread(new Person("disaster9",cave)).start();
        new Thread(new Person("disaster10",cave)).start();

    }
}

class Person implements Runnable {
    private String nama;
    private Cave cave;

    public Person(String nama, Cave cave) {
        this.nama = nama;
        this.cave = cave;
    }

    @Override
    public void run() {
            synchronized (cave){
                System.out.println(this.nama+"正在通过通道");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(this.nama+"已走完通道！");
                System.out.println("================================");
            }
    }
}

class Cave {

}