package hongchengstudy.abstracclass.v4;

public class Hotel implements Eat,Accommodation {
    @Override
    public void sleep() {
        System.out.println("在酒店吃饭");
    }

    @Override
    public void eat() {
        System.out.println("在酒店睡觉");
    }
}
