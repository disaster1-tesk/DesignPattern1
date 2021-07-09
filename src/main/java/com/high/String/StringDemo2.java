package com.high.String;

public class StringDemo2 {
    public static void main(String[] args) {


        //index方法返回指定值在String字符串第一次出现的下标（String对象底层数据是一个byte【】数组）
        String str = "123456";
        int number = str.indexOf("234");
        System.out.println(number);


        //charAt方法返回的是指定下标的char字符的二进制数
        int number1 = "adsg".charAt(0);
        System.out.println(number1);


        //compareTo比较两个字符串的大小
        System.out.println("abcde".compareTo("abdce"));


        //sqlit方法将一个字符串按照规定的符号进行区分
        String[] split = "htttp://www.12345.1544.com".split(":");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }


        //getBytes方法，将一个字符串转换成一个byte数组
        byte[] bytes = "ad12345".getBytes();
        for (int i = 0; i < bytes.length; i++) {
            System.out.println(bytes[i]);
        }

        //replace方法将String字符串中的指定的字符换成其他字符
        String newstring = "asdfadf12332".replace("asd", "111");
        System.out.println(newstring.toString());


        //boolean endsWith(String suffix) 测试如果这个字符串以指定的后缀结束
        boolean flag = "asdfasdfa".endsWith("a");
        System.out.println(flag);

        //equals(Object anObject) 将此字符串与指定的对象比较。
        System.out.println("asfasdf".equals("asdf"));

        //equalsIgnoreCase(String anotherString) 比较这 String到另一个 String，忽略问题的考虑。
        System.out.println("ABcd".equalsIgnoreCase("abcd"));

        //toCharArray() 将此字符串转换为一个新的字符数组。
        char[] chars = "abcd".toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i] + "--");
        }
        System.out.println();
        //valueOf(参数类型 参数) 能够将不同类型的数据转换成字符串(这个方法是String类中的一个静态方法！！）
        System.out.println(String.valueOf(true) + String.valueOf(100) + String.valueOf(100L));


    }


}
