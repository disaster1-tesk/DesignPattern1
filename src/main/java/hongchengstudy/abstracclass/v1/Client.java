package hongchengstudy.abstracclass.v1;

public class Client {
    public static void main(String[] args) {
        Mammal lion = new Lion(180,300);
        Mammal dolphin = new Dolphin(100,200);
        lion.doSomething();
        dolphin.doSomething();
    }
}
