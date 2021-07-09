package hongchengstudy.abstracclass.v1;

public class Dolphin extends TerrestrialMammal{
    public Dolphin(int height, int weight) {
        super(height, weight);
    }

    public Dolphin() {
    }

    @Override
    public void doSomething() {
        System.out.println("身高为："+super.height+"体重为："+super.weight);
    }
}
