package hongchengstudy.io.test.v1;


import java.io.*;

public class Client {
    public static void main(String[] args) throws IOException {
        File file = new File("D:" + File.separator + "桌面文件" + File.separator + "FIle" + File.separator + "test.txt");
        System.out.println(funV1(file));
        System.out.println(funV2(file));
    }

    public static StringBuilder funV1(File file) throws IOException {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] buff = new byte[(int)file.length()];
        int n = -1;
        while ((n = bis.read(buff)) != -1) {
            String s = new String(buff, 0, n);
            sb.append(s+"\n");
        }
        fis.close();
        bis.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return sb;
    }

    public static StringBuilder funV2(File file) throws IOException {
        long start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        FileReader br = new FileReader(file);
        BufferedReader bfr = new BufferedReader(br,1024);
        String str = "";
        while ((str=bfr.readLine())!=null){
            sb.append(str);
            sb.append("\n");
        }
        br.close();
        bfr.close();
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return sb;
    }
}
