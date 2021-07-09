package hongchengstudy.abstracclass.v5.feeder;

import hongchengstudy.abstracclass.v5.animal.Animal;

public class Feeder {
    private String name;
    private Animal animal;


    public Feeder(String name, Animal animal) {
        this.name = name;
        this.animal = animal;
    }

    public Feeder() {

    }

    public void feed(){
        System.out.println("饲养员"+name+"准备喂食");
        animal.eat();
    }
}
