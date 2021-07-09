package hongchengstudy.work.bank;

public class Login {
    private static String NAME;
    private static String PASSWORD;
    static {
        NAME = "disaster";
        PASSWORD = "123456";
    }
    public static boolean login(String name,String passWord){
        if (name.equals(NAME) && passWord.equals(PASSWORD)) {
            return true;
        }
        return false;
    }
}
