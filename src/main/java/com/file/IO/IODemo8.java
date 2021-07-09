package com.file.IO;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
对于DataOutputStream流，我们开发中使用的频率不高，这种流能够写入数据的格式和数据内容。
 */
public class IODemo8 {
    public static void main(String[] args) {
        DataInputStream dis = null;
        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("data"));
            dis = new DataInputStream(new FileInputStream("data"));
            byte b = 100;
            short s = 200;
            long l = 300L;
            float f = 400;
            double d = 3.14;
            int i = 500;
            boolean sex = true;
            char c = 'a';
            dos.writeBoolean(sex);
            dos.writeByte(b);
            dos.writeChar(c);
            dos.writeDouble(d);
            dos.writeFloat(f);
            dos.writeInt(i);
            dos.writeLong(l);
            dos.writeShort(s);
            dos.flush();
            boolean b1 = dis.readBoolean();
            byte b2 = dis.readByte();
            char c1 = dis.readChar();
            double v = dis.readDouble();
            float v1 = dis.readFloat();
            int i1 = dis.readInt();
            long l1 = dis.readLong();
            short i2 = dis.readShort();
            List list = new ArrayList();
            list.add(b1);
            list.add(b2);
            list.add(c1);
            list.add(v);
            list.add(v1);
            list.add(i1);
            list.add(l1);
            list.add(i2);
            Iterator iterator = list.iterator();
            while(iterator.hasNext()){
//                自动拆箱
                System.out.println(iterator.next());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (dis == null) {
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
