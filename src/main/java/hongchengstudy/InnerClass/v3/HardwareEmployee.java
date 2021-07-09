package hongchengstudy.InnerClass.v3;

public class HardwareEmployee extends MaintainEmployee{
    public HardwareEmployee(int id, String name) {
        super(id, name);
    }

    public HardwareEmployee() {
    }

    @Override
    public void work() {
        System.out.println("员工号为"+super.getId()+"的"+super.getName()+"员工，正在修复设备");
    }

}
