package hongchengstudy.abstracclass.v4;

public class Client {
    public static void main(String[] args) {
        DiningHall diningHall = new DiningHall();
        Dormitory dormitory = new Dormitory();
        FacultyCanteen facultyCanteen = new FacultyCanteen();
        Hotel hotel = new Hotel();
        StudentsApartment studentsApartment = new StudentsApartment();
        WineHouse wineHouse = new WineHouse();
        Person student = new Student(diningHall,dormitory,"学生");
        Person leader = new Leader(hotel,hotel,"领导");
        Person teacher = new Teacher(facultyCanteen,studentsApartment,"老师");
        Person foreign = new Foreign(wineHouse,wineHouse,"外宾");

        student.eat();
        student.sleep();

        leader.eat();
        leader.sleep();

        teacher.eat();
        teacher.sleep();

        foreign.eat();
        foreign.sleep();

    }
}
