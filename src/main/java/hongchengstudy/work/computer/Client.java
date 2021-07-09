package hongchengstudy.work.computer;

import java.util.ArrayList;
import java.util.List;

/*
写一个生产电脑和搬运电脑的程序。要求生产出一台电脑就搬走一台电脑。
如果新的电脑没有生产出来，则搬运工就要等待；
如果生产出的电脑没有搬走，则要等待电脑搬走后再生产。
 */
public class Client {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Computer> computerArrayList = new ArrayList<>();
        new Thread(new ComputerFactory(computerArrayList)).start();
        new Thread(new Porter(computerArrayList)).start();
    }
}

class Computer {
}

class ComputerFactory implements Runnable {
    private List<Computer> computerList;

    public ComputerFactory(List<Computer> computerList) {
        this.computerList = computerList;
    }

    @Override
    public void run() {
        Computer computer = new Computer();
        synchronized (computerList) {
            while (true) {
                if (computerList.size() == 0) {
                    System.out.println("电脑工厂准备生产电脑....");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    computerList.add(computer);
                    System.out.println("电脑生产出来了");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    computerList.notifyAll();
                    try {
                        computerList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    computerList.notifyAll();
                    try {
                        computerList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

class Porter implements Runnable {
    private List<Computer> computerList;

    public Porter(List<Computer> computerList) {
        this.computerList = computerList;
    }

    @Override
    public void run() {
            synchronized (computerList){
                while (true) {
                    if (computerList.size()!=0){
                        System.out.println("工人正在搬运电脑...");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        computerList.remove(0);
                        System.out.println("电脑被搬走了");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        computerList.notifyAll();
                        try {
                            computerList.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }else{
                        computerList.notifyAll();
                        try {
                            computerList.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
    }
}