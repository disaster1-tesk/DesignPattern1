package hongchengstudy.work.inputinformation;

import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        UserService.setFileInfo("D:" + File.separator + "桌面文件" + File.separator + "FIle" +
                File.separator + "图书" + File.separator + "UserInfo.txt");
        while(true){
            System.out.println("===========会员信息录入===========");
            System.out.println("会员姓名：");
            String name = br.readLine();
            System.out.println("会员年龄：");
            int age = Integer.valueOf(br.readLine());
            System.out.println("会员性别：");
            String sex = br.readLine();
            System.out.println("会员地址：");
            String address = br.readLine();
            UserService.InputInfo(new User(name,age,sex,address));
            System.out.println("录入成功，是否继续（Y/N）");
            String flag = br.readLine();
            if (flag.equals("N")){
                System.out.println("GoodBye");
                break;
            }
        }
    }
}
