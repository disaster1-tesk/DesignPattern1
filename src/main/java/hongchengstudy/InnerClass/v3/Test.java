package hongchengstudy.InnerClass.v3;

public class Test {
    public static void main(String[] args) {
        DevelopmentEmployee javaEmployee = new JavaEmployee(10001,"小明");
        DevelopmentEmployee webEmployee = new WebEmployee(10002,"小红");
        MaintainEmployee networkEmployee = new NetworkEmployee(100003,"小华");
        MaintainEmployee hardwareEmployee = new HardwareEmployee(100004,"小浩");
        javaEmployee.work();
        webEmployee.work();
        networkEmployee.work();
        hardwareEmployee.work();
    }
}
