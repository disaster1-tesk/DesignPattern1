package hongchengstudy.map.treemap;

import java.util.Comparator;
import java.util.TreeMap;

public class Client {
    public static void main(String[] args) {
        TreeMap<String, String> treeMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        treeMap.put("disaster1","hello disaster1");
        treeMap.put("disaster11","hello disaster11");
        treeMap.put("disaster111","hello disaster111");
        treeMap.put("disaster111","hello disaster112");
        System.out.println(treeMap);
    }
}
