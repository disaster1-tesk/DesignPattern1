package com.high.Random;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RandomDemo2 {
    public static void main(String[] args) {
        int[] Numbers;
        int index=0;
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        System.out.println("输入你想获得的不重复的随机数的个数：");
        int listnumber = sc.nextInt();
        Numbers = new int[listnumber];
        while (index<Numbers.length){
            int randomnumber = random.nextInt(20);
            int i = Arrays.binarySearch(Numbers, randomnumber);
            if (i<0){
                Numbers[index]=randomnumber;
                index++;
            }
        }
        Arrays.sort(Numbers);
        for (int i = 0; i < Numbers.length; i++) {
            System.out.println(Numbers[i]);

        }
    }
}
