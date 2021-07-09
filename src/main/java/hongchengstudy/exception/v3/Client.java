package hongchengstudy.exception.v3;

import java.util.ArrayList;

public class Client {
    public static void print(ArrayList list){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        print(list);
    }
}
