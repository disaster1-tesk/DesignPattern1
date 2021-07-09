package hongchengstudy.work.lotterysystem;

import java.util.*;

public class LotterySys {
    private List<String> empList;
    private List<String> prizeList;

    public LotterySys() {
        empList = new ArrayList<>();
        prizeList = new ArrayList<>();
        empList.add("disaster1");
        empList.add("disaster2");
        empList.add("disaster3");
        empList.add("disaster4");
        empList.add("disaster5");
        empList.add("disaster6");
        empList.add("disaster7");
        empList.add("disaster8");
        prizeList.add("篮球");
        prizeList.add("足球");
        prizeList.add("网球");
    }

    public HashMap<String, String> lottery() {
        HashMap<String, String> map = new HashMap<>();
        if (empList.size() == 0 || prizeList.size() == 0) {
            return null;
        }
        String emp = null;
        String prizes = null;
        int empRandom = -1;

        if (empList.size() - 1 == 0) {
            empRandom = 0;
        } else {
            empRandom = new Random().nextInt(empList.size() - 1);
        }

        int prizesRandom = new Random().nextInt(prizeList.size() + 1);
        emp = empList.get(empRandom);

        if (!(prizesRandom >= prizeList.size())) {
            prizes = prizeList.get(prizesRandom);
            prizeList.remove(prizes);
        }

        empList.remove(emp);
        map.put(emp, prizes);
        return map;
    }
}
