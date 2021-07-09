package hongchengstudy.abstracclass.v1;

public abstract class MarineMammal implements Mammal {
      protected int height;
      protected int weight;

    public MarineMammal(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public MarineMammal() {
    }
    public abstract void doSomething();
}
