package hongchengstudy.work.createsql;

import java.lang.reflect.Field;

/*
题目：根据类和成员变量生成insert SQL语句
1、定义三个注解：
	@Table:该注解用于类上，并能传入指定的表名称
	@Key：该注解用于成员变量上，标明该成员变量是主键
	@NotRecord：该注解用于成员变量上，标明该成员变量不生成SQL语句
 */
public class Client {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException {
        //获取class
        Person disaster = new Person(10, "disaster", 20, 180, 150);
        StringBuilder sb = getSQL(disaster);
        System.out.println(sb);
    }

    private static StringBuilder getSQL(Person person) throws IllegalAccessException, ClassNotFoundException {
        Class personClass = person.getClass();
        StringBuilder sb = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        sb.append("INSERT INTO ");
        Table annotation = (Table) personClass.getAnnotation(Table.class);
        if (annotation != null) {
            sb.append(annotation.tableName() + " ");
            sb.append("(");
        }else {
            throw new ClassNotFoundException();
        }
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            declaredField.setAccessible(true);
            if (declaredField.isAnnotationPresent(Key.class) && declaredField.get(person) != null) {
                sb.append(declaredField.getName() + ",");
                if (declaredField.get(person) instanceof String) {
                    stringBuilder.append("'" + declaredField.get(person) + "',");
                } else {
                    stringBuilder.append(declaredField.get(person) + ",");
                }
            } else if (declaredField.isAnnotationPresent(NotRecord.class)) {

            } else {
                sb.append(declaredField.getName() + ",");
                if (declaredField.get(person) instanceof String){
                    stringBuilder.append("'" + declaredField.get(person) + "',");
                }else{
                    stringBuilder.append(declaredField.get(person) + ",");
                }
            }
        }
        sb.append(")");
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append(" VALUES ");
        stringBuilder.append(");");
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        sb.append(stringBuilder);
        return sb;
    }
}

@Table(tableName = "person")
class Person {
    @Key
    private int uerId;
    private String name;
    @NotRecord
    private int age;
    @NotRecord
    private int height;
    private int weight;

    public Person() {
    }

    public Person(int uerId, String name, int age, int height, int weight) {
        this.uerId = uerId;
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
}