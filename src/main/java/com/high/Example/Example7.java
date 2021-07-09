package com.high.Example;

import java.util.Objects;

/*
开发型题目，随意发挥：
        写一个类Army,代表一支军队，这个类有一个属性Weapon数组w（用来存储该军队所拥有的的所有的武器）
        该类还提供一个构造方法，在构造方法里通过传一个int类型的参数来限定该类所能拥有的最大武器数量，
        并用这一大小来初始化数组w.

        该类还提供一个方法addWeapon(Weapon wa），表示把参数wa所代表的武器假如到数组w中。
        在这个类中还定义两个方法attackall（）让数组中的所有武器攻击：
        以及moveAll（）让w数组中的所有可移动的武器移动。

        写一个主方法去测试以上程序。


        提示：
            Weapon是一个父类。应该有很多紫武器。
            这些紫武器应该有有一些是可移动的，有一些是可攻击的。



 */
public class Example7 {
    public static void main(String[] args) {
        Army army = new Army("海军陆战队", "陆军", 10);
        MachineGun machineGun = new MachineGun("机关枪", "连发枪", "10000");
        try {
            army.addWeapon(machineGun);
            System.out.println(machineGun.getName() + "已加入武器库");
        } catch (WeaponAnomaly e) {
            e.printStackTrace();
        }
        for (int i = 0; i < army.getWeapons().length; i++) {
            if (army.getWeapons()[i] != null) {
                System.out.println(army.getWeapons()[i].getName() + army.getWeapons()[i].getType() + army.getWeapons()[i].getPrice());
            }
        }
    }
}

class MachineGun extends Weapon implements WeaponDo {

    public MachineGun() {
        super();
    }

    public MachineGun(String name, String type, String price) {
        super(name, type, price);
    }

    @Override
    public void move() {
        System.out.println(this.getName() + "即将攻击");
    }

    @Override
    public void attack() {
        System.out.println(this.getName() + "即将移动！");
    }
}

class Army {
    private Weapon[] weapons;
    private String name;
    private String Type;

    public Army() {
    }

    public Army(String name, String type, int Weaponnumber) {
        this(Weaponnumber);
        this.name = name;
        Type = type;
    }

    public Army(int Weaponnumber) {
        this.weapons = new Weapon[Weaponnumber];
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    public void setWeapons(Weapon[] weapons) {
        this.weapons = weapons;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public void destroy(Weapon wa) throws WeaponAnomaly {
        if (wa == null) throw new WeaponAnomaly("武器不能为空！");
        for (int i = 0; i < this.getWeapons().length; i++) {
            if (wa.equals(this.getWeapons()[i])) {
                this.getWeapons()[i] = null;
                System.out.println(this.getWeapons()[i].getType() + this.getWeapons()[i].getName() + "已经被移除武器库！");
            } else {
                System.out.println(this.getName() + "中没有这种武器！");
            }
        }
    }

    public void addWeapon(Weapon wa) throws WeaponAnomaly {
        if (wa == null) throw new WeaponAnomaly("武器不能为空！");
        for (int i = 0; i < this.getWeapons().length; i++) {
            if (this.getWeapons()[i] == null) {
                this.getWeapons()[i] = wa;
                break;
            } else {
                System.out.println("武器库中没有这种武器！");
            }
        }

    }
}

class Weapon {
    private String name;
    private String Type;
    private String Price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return Objects.equals(name, weapon.name) &&
                Objects.equals(Type, weapon.Type) &&
                Objects.equals(Price, weapon.Price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Type, Price);
    }

    public Weapon() {

    }

    public Weapon(String name, String type, String price) {
        this.name = name;
        Type = type;
        Price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }
}

interface WeaponDo {
    void move();

    void attack();

}

class WeaponAnomaly extends Exception {
    public WeaponAnomaly() {
    }

    public WeaponAnomaly(String message) {
        super(message);
    }
}