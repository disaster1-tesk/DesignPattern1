package hongchengstudy.generics.v1;

import java.util.List;

public class Lottery<T> {
    private List<T> prizesList;

    public Lottery(List<T> prizesList) {
        this.prizesList = prizesList;
    }

    //添加奖品
    public boolean addPrizes(T t) {
        if (prizesList.add(t)) {
            return true;
        }
        return false;
    }
    //抽奖
    public T lottery(){
        return prizesList.size()==0?null:prizesList.get((int)(Math.random()*prizesList.size()));
    }
}
