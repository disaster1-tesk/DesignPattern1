package hongchengstudy.InnerClass.v4;


public class Operation {
    private User[] userList;
    private int count = 0;

    public Operation(int listLength) {
        if (listLength < 0) {
            userList = new User[10];
        } else {
            userList = new User[listLength];
        }
    }

    public Operation() {
        userList = new User[10];
    }

    public void setUserList(User[] userList) {
        this.userList = userList;
    }

    public User[] getUserList() {
        return userList;
    }

    //注册方法
    public int register(User user) {
        if (count > userList.length) {
            User[] newUserList = new User[userList.length * 2];
            for (int i = 0; i < userList.length; i++) {
                newUserList[i] = userList[i];
            }
            setUserList(newUserList);
        }

        for (int i = 0; i < userList.length; i++) {
            if (userList[i]==null){
                userList[i] = user;
                count++;
                return i;
            }else{
                if (!(userList[i].getName().equals(user.getName()))&&userList[i].getPassWord().equals(user.getPassWord())) {
                    userList[i] = user;
                    count++;
                    return i;
                }
            }
            }
        return -1;
    }

    //登录功能
    public int login(String userName,String passWord) {
        for (int i = 0; i < count; i++) {
            if (userList[i]!=null&&userList[i].getName().equals(userName)&&userList[i].getPassWord().equals(passWord)) {
                return i;
            }
        }
        return -1;
    }
    //查询功能
    public void findAll(){
        for (int i = 0; i < count; i++) {
            if (userList[i]!=null){
                System.out.println(userList[i]);
            }else{
                System.out.println("null");
            }
        }
    }

    //抽奖方法
    public void lottery(int number) {
        for (int i = 0; i < count; i++) {
            if (userList[i]!=null&&userList[i].getVipID() == number) {
                System.out.println("今天的幸运数字为" + number + "，恭喜您成为今天的幸运用户");
            }
        }
        System.out.println("今天的幸运数字为" + number + "，很遗憾您不是今天的幸运用户");
    }

    //修改密码
    public boolean updatePassWord(int userIndex,String passWord) {
        if (userIndex>=0){
            userList[userIndex].setPassWord(passWord);
            return true;
        }
        return false;
    }

    //删除方法
    public boolean deleteUser(int userIndex) {
        if (userIndex>=0&&userList[userIndex]!=null){
            userList[userIndex]=userList[userList.length-1];
            userList[userList.length-1]=null;
            count--;
            return true;
        }
        return false;
    }
}
