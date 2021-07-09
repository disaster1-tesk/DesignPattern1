package hongchengstudy.InnerClass.v3;

public class JavaEmployee extends DevelopmentEmployee{
    public JavaEmployee() {
    }

    public JavaEmployee(int id, String name) {
        super(id, name);
    }

    @Override
    public void work() {
        System.out.println("员工号为"+super.getId()+"的"+super.getName()+"员工，正在研发后台服务器");
    }
}
