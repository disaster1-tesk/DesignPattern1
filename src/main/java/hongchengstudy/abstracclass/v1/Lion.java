package hongchengstudy.abstracclass.v1;

public class Lion extends MarineMammal {
    public Lion(int height, int weight) {
        super(height, weight);
    }

    public Lion() {
    }

    @Override
    public void doSomething() {
        System.out.println("身高为："+super.height+"体重为："+super.weight);
    }
}
