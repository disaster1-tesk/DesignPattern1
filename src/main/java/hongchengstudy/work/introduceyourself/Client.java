package hongchengstudy.work.introduceyourself;

public class Client {
    public static void main(String[] args) {
        Student disaster1 = new Student("disaster1", 20);
        Student disaster2 = new Student("disaster2", 30);
        Student disaster3 = new Student("disaster3", 40);
        new Thread(disaster1).start();
        new Thread(disaster2).start();
        new Thread(disaster3).start();
    }
}
