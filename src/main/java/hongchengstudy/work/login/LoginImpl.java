package hongchengstudy.work.login;

import java.util.Iterator;
import java.util.List;

public class LoginImpl implements Login{
    private List userList;

    public LoginImpl( List userList) {
        this.userList = userList;
    }

    @Override
    public boolean login(User user) {
        Iterator iterator = userList.iterator();
        while (iterator.hasNext()){
            if ( iterator.next().equals(user)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean register(User user) {
        Iterator iterator = userList.iterator();
        while (iterator.hasNext()){
            if ( iterator.next().equals(user)){
                return false;
            }
        }
        userList.add(user);
        return true;
    }
}
