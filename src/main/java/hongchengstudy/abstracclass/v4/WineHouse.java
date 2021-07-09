package hongchengstudy.abstracclass.v4;

public class WineHouse implements Eat,Accommodation {
    @Override
    public void sleep() {
        System.out.println("在宾馆睡觉");
    }

    @Override
    public void eat() {
        System.out.println("在宾馆吃饭");
    }
}
