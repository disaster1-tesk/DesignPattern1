package hongchengstudy.abstracclass.v1;

public abstract class TerrestrialMammal implements Mammal{
    protected int height;
    protected int weight;

    public TerrestrialMammal(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public TerrestrialMammal() {
    }
    public abstract void doSomething();
}
