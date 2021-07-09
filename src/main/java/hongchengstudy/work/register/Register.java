package hongchengstudy.work.register;

import java.util.ArrayList;
import java.util.List;

public class Register {
    private List<UserBean> userBeanList;

    public Register() {
        userBeanList = new ArrayList<>();
    }

    public boolean register(UserBean userBean) throws MyException {
        if (userBean.getPwd().length()<6){
            throw new MyException("密码长度不能小于6位");
        }
        if (userBean==null){
            throw new MyException("参数列表不正确！");
        }
        for (UserBean user: userBeanList) {
            if (user.equals(userBean)){
                return true;
            }
        }
        throw new MyException("用户注册失败！");
    }
}
