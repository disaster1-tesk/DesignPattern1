package hongchengstudy.abstracclass.v5.animal;

import hongchengstudy.abstracclass.v5.food.Food;

public class Dog extends Animal implements Food {
    private Food food;
    public Dog(String type, String name) {
        super(type, name);
    }

    public Dog(String type, String name, Food food) {
        super(type, name);
        this.food = food;
    }

    @Override
    public void eat() {
        System.out.print(type+name);
        food.beEaten();
    }

    @Override
    public void beEaten() {
        System.out.println("吃"+type+name);
    }
}
