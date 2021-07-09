package com.high.Random;

import java.util.Random;

public class RandomDemo1 {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(10);
        int b = random.nextInt();
        System.out.println(i+"----"+b);
    }
}
