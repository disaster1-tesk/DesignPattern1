package hongchengstudy.map.hashmap;

import java.util.HashMap;

public class Client {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("a",10);
        hashMap.put("b",20);
        hashMap.put("c",30);
        hashMap.put("d",40);
        hashMap.put("e",50);
        System.out.println(hashMap);
    }
}
