package hongchengstudy.InnerClass.v4;

import java.util.Objects;

public class User {
    private String name;
    private String passWord;
    private int vipID;

    public User(String name, String passWord, int vipID) {
        this.name = name;
        this.passWord = passWord;
        this.vipID = vipID;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getVipID() {
        return vipID;
    }

    public void setVipID(int vipID) {
        this.vipID = vipID;
    }

    public boolean equal(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User)o;
        return Objects.equals(name, user.name) &&
                Objects.equals(passWord, user.passWord);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", passWord='" + passWord + '\'' +
                ", vipID=" + vipID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return vipID == user.vipID &&
                name.equals(user.name) &&
                passWord.equals(user.passWord);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passWord, vipID);
    }
}
