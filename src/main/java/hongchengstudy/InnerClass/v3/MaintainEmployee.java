package hongchengstudy.InnerClass.v3;

public class MaintainEmployee extends Employee{
    public MaintainEmployee(int id, String name) {
        super(id, name);
    }

    public MaintainEmployee() {
    }

    @Override
    public void work() {
        super.work();
    }
}
