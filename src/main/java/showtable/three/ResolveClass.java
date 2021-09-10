package showtable.three;

/**
 * @ClassName ResolveClass
 * @Description TODO
 * @Author Disaster
 * @Date 2021/8/17 21:53
 * @Version 1.0
 **/
public class ResolveClass extends ClassLoader {
    ResolveClass(Class cl1) {
        // By using super keyword to call parent class
        // Constructor
        super.resolveClass(cl1);

        // Display Resolve Class Name
        System.out.println("Class Name: " + cl1.getSimpleName());
    }

    public static void main(String[] args) throws Exception {
        // We are parsing Class to ClassLoader constructor
        Class cl = Class.forName("java.lang.String");

        // Calling ResolveClass Constructor
        ResolveClass rc = new ResolveClass(cl);
    }
}
