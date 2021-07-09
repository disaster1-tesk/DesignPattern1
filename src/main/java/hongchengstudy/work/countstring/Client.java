package hongchengstudy.work.countstring;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入你想输入的字符串：");
        TreeMap<Character, Integer> treeMap = funV1(scanner.nextLine());
        Set<Character> characters = treeMap.keySet();
        System.out.print("result:  ");
        for (Character c: characters) {
            System.out.print(" ("+treeMap.get(c)+") "+c+" ");
        }
    }
    public static TreeMap<Character,Integer> funV1(String str){
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        String str1=str.trim();
        char[] chars = str1.toCharArray();
        for (char c: chars) {
            if (treeMap.get(c)==null){
                treeMap.put(c,1);
            }else{
                treeMap.put(c,treeMap.get(c)+1);
            }
        }
        return treeMap;
    }
}