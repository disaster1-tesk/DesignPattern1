package hongchengstudy.work.randomstring;

import java.util.Random;

/*
产生一个长度为15位的随机字符串：大写小写和数字，最后输出该随机字符串
 */
public class Client {
    public static void main(String[] args) {
        StringBuilder randomString = createRandomString();
        System.out.println(randomString);
    }

    public static StringBuilder createRandomString() {
        StringBuilder sb = new StringBuilder();
        char ch = ' ';
        int chInt = 0;
        while (true) {
            int num = (int) (Math.random() * 100);
            int flag = num % 3;
            switch (flag) {
                case 0:
                    chInt = (int) (Math.random() * 26 + 65);
                    ch = (char) chInt;
                    sb.append(ch);
                    break;
                case 1:
                    chInt = (int) (Math.random() * 26 + 97);
                    ch = (char) chInt;
                    sb.append(ch);
                    break;
                case 2:
                    chInt = (int) (Math.random()*10);
                    sb.append(chInt);
                    break;
                default:
                    break;
            }
            if (sb.length()>=15){
                return sb;
            }
        }
    }
}
