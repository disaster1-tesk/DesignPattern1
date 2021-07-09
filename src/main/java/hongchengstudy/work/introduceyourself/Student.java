package hongchengstudy.work.introduceyourself;

public class Student extends Person implements Runnable{

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void introduceYourself() {
        System.out.println("大家好,我叫"+name+"今年"+age);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            introduceYourself();
        }
    }
}
