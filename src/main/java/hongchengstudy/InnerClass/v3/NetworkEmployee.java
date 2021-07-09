package hongchengstudy.InnerClass.v3;

public class NetworkEmployee extends MaintainEmployee {
    public NetworkEmployee(int id, String name) {
        super(id, name);
    }

    public NetworkEmployee() {
    }

    @Override
    public void work() {
        System.out.println("员工号为"+super.getId()+"的"+super.getName()+"员工，正在检查网络是否畅通");
    }
}
