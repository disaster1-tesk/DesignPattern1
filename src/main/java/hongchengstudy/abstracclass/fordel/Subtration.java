package hongchengstudy.abstracclass.fordel;

import hongchengstudy.abstracclass.forcom.Compute;

public class Subtration extends Compute {
    @Override
    public int compute(int a, int b) {
        if (a>b){
            return a-b;
        }
        return b-a;
    }
}
