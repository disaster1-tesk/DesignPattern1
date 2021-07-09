package hongchengstudy.abstracclass.v5.animal;

public abstract class Animal {
    protected String type;
    protected String name;

    public Animal(String type, String name) {
        this.type = type;
        this.name = name;
    }
    public abstract void eat();
}
