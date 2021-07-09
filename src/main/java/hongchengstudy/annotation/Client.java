package hongchengstudy.annotation;
public class Client {
    public static void main(String[] args) {

    }
    @MyAnnotation(value = "nihao",age = 20,enumField = MyEnum.Autumn)
    public static void getName(String name) {
    }
    /**
    * @dscription
    * @param []
    * @return int
    **/
    @Deprecated
    public static int getAge(){
        return 10;
    }
}
