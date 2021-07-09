package hongchengstudy.abstracclass.v4;

public class Student implements Person {
    private Eat eat;
    private Accommodation accommodation;
    private String name;
    public Student(Eat eat, Accommodation accommodation) {
        this.eat = eat;
        this.accommodation = accommodation;
    }

    public Student(Eat eat, Accommodation accommodation, String name) {
        this.eat = eat;
        this.accommodation = accommodation;
        this.name = name;
    }
    @Override
    public void eat() {
        System.out.print(this.name);
        eat.eat();
    }

    @Override
    public void sleep() {
        System.out.print(this.name);
        accommodation.sleep();
    }
}
