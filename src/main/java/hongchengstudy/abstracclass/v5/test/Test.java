package hongchengstudy.abstracclass.v5.test;

import hongchengstudy.abstracclass.v5.animal.Cat;
import hongchengstudy.abstracclass.v5.animal.Dog;
import hongchengstudy.abstracclass.v5.feeder.Feeder;
import hongchengstudy.abstracclass.v5.food.Bone;
import hongchengstudy.abstracclass.v5.food.Fish;

public class Test {
    public static void main(String[] args) {
        Bone bone = new Bone();
        Fish fish = new Fish();
        Cat cat = new Cat("家猫", "小花", fish);
        Dog dog = new Dog("哈士奇", "小黄", bone);
        Feeder disaster = new Feeder("disaster", cat);
        Feeder disaster1 = new Feeder("disaster1", dog);
        disaster.feed();
        disaster1.feed();
    }
}
