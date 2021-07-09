package hongchengstudy.jdbc.v6;

/**
 * @ClassName Person
 * @Description TODO
 * @Author Disaster
 * @Date 2021/7/8 15:53
 * @Version 1.0
 **/
public class Student {
    private Integer id;
    private String name;
    private String age;
    private String sex;
    private String password;

    public Student() {
    }

    public Student(Integer id, String name, String age, String sex, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
