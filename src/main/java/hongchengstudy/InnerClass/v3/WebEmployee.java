package hongchengstudy.InnerClass.v3;

public class WebEmployee extends DevelopmentEmployee {
    public WebEmployee(int id, String name) {
        super(id, name);
    }

    public WebEmployee() {
    }

    @Override
    public void work() {
        System.out.println("员工号为"+super.getId()+"的"+super.getName()+"员工，正在研发前端网站");
    }
}
