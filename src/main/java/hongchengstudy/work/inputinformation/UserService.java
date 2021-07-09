package hongchengstudy.work.inputinformation;

import java.io.*;

public class UserService {
    static File file = null;

    public static void setFileInfo(String fileAddress) {
        file = new File(fileAddress);
    }

    public static File getFile() {
        return file;
    }

    public static void InputInfo(User user) throws IOException {
        FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.newLine();
        bw.write("会员姓名："+user.getName()+"\n"+"会员年龄:"+user.getAge()+"\n"+"会员性别:"+user.getSex()+"\n"+"会员地址:"+user.getAddress()+"\n");
        bw.write("**************************************************");
        bw.flush();
        bw.close();
    }
}
