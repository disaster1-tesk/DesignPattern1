package com.high.Example;

import java.util.Objects;
import java.util.Scanner;

/*
为某个酒店编写程序：酒店管理系统，模拟订房、退房、打印所有房间状态等功能
    1.改系统的用户是：酒店前台
    2.酒店中所有的房间使用一个二维数组来模拟。“Room[][] rooms;"
    3.酒店中的每一个房间应该是一个java对象：Room
    4.每一个房间Room应该有：房间编号、房间类型属性、房间是否空闲。
    5.系统应该对外提供的功能：
        可以预订房间：用户输入房间编号、订房
        可以退房：用户输入房间编号，退房
        可以查看所有房间的状态：用户输入某个指令应该可以查看所有房间状态；

 */
public class Example5 {
    public static void main(String[] args) {
        Room[][] rooms = {
                {new Room(101, "总统房", false), new Room(102, "总统房", false), new Room(103, "总统房", false), new Room(104, "总统房", false)},
                {new Room(201, "VIP房", false), new Room(202, "VIP房", false), new Room(203, "VIP房", false), new Room(204, "VIP房", false)},
                {new Room(301, "普通房", false), new Room(302, "普通房", false), new Room(303, "普通房", false), new Room(304, "普通房", false)}
        };
        Hotel hotel = new Hotel(rooms);
        System.out.println("---------------------------------------------------酒店前台-----------------------------------");
        System.out.println("您是否来租房？(1.表示是 2.表示否)");
        Scanner scanner = new Scanner(System.in);
        Customer customer = new Customer("disaster", "1315456", hotel);
        int index = scanner.nextInt();
        if (index == 1) {
            System.out.println("-----------------------------------欢迎来到爽歪歪酒店！！------------------------------");
            System.out.println("请选择您要的操作：");
            System.out.println("1.查看所有房间的信息");
            System.out.println("2.预订房间");
            System.out.println("3.退房间");
            System.out.println("4.退出酒店");
            while (true) {
                int flag = scanner.nextInt();
                if (flag == 1) {
                    customer.showRoomInformation();
                    System.out.println("请选择您要的操作：");
                } else if (flag == 2) {
                    System.out.println("请输入您要预订的房间号码：");
                    int roomnumber = scanner.nextInt();
                    customer.BookARoom(roomnumber);
                    System.out.println("请选择您要的操作：");
                } else if (flag == 3) {
                    System.out.println("请输入您要退房的房间号码：");
                    int roomnumber = scanner.nextInt();
                    customer.CheckOutRoom(roomnumber);
                    System.out.println("请选择您要的操作：");
                } else if (flag == 4) {
                    break;
                } else {
                    System.out.println("您的号码输入有误，请重新输入！");
                }
            }
        } else {
            System.out.println("欢迎您的下次光临！" + customer.getName());
        }

    }
}

class Room {
    private int Number;
    private String Type;
    private Boolean Flag;

    public Room() {
    }

    public Room(int number, String type, Boolean flag) {
        Number = number;
        Type = type;
        Flag = flag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Number == room.Number &&
                Objects.equals(Type, room.Type) &&
                Objects.equals(Flag, room.Flag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Number, Type, Flag);
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public Boolean getFlag() {
        return Flag;
    }

    public void setFlag(Boolean flag) {
        Flag = flag;
    }
}

class Hotel {
    private Room[][] rooms;

    public Hotel(Room[][] rooms) {
        this.rooms = rooms;
    }

    //展示所有房房间的信息
    public boolean ShowInformathon() {
        for (int i = 0; i < this.rooms.length; i++) {
            System.out.println("第" + (i + 1) + "层：");
            for (int j = 0; j < this.rooms[i].length; j++) {
                System.out.println("房间号：" + this.rooms[i][j].getNumber() + "------" + "类型:" + this.rooms[i][j].getType() + "------" + "房间状态：" + this.rooms[i][j].getFlag());
            }
        }
        return false;
    }

    //预订房间
    public boolean BookingRoom(int Number) {
        for (int i = 0; i < this.rooms.length; i++) {
            for (int j = 0; j < this.rooms[i].length; j++) {
                if (this.rooms[i][j].getNumber() == Number) {
                    System.out.println("房间号：" + this.rooms[i][j].getNumber() + "------" + "类型:" + this.rooms[i][j].getType() + "------" + "房间状态：" + this.rooms[i][j].getFlag());
                    if (this.rooms[i][j].getFlag() == false) {
                        this.getRooms()[i][j].setFlag(true);
                        System.out.println("您已成功预订房间！");
                        return true;
                    } else {
                        System.out.println("房间已被预订，请您预订其他房间！");
                        return false;
                    }
                }
            }
        }
        return false;
    }

    //退房
    public boolean CheckOut(int Number) {
        for (int i = 0; i < this.rooms.length; i++) {
            for (int j = 0; j < this.rooms[i].length; j++) {
                if (this.rooms[i][j].getNumber() == Number) {
                    System.out.println("房间号：" + this.rooms[i][j].getNumber() + "------" + "类型:" + this.rooms[i][j].getType() + "------" + "房间状态：" + this.rooms[i][j].getFlag());
                    if (this.rooms[i][j].getFlag() == false) {
                        System.out.println("这个房间还未出租，请您重新输入您的房间！");
                        return true;
                    } else {
                        this.getRooms()[i][j].setFlag(false);
                        System.out.println("您已成功退房！");
                        return false;
                    }

                }
            }
        }
        return false;
    }


    public Room[][] getRooms() {
        return rooms;
    }

    public void setRooms(Room[][] rooms) {
        this.rooms = rooms;
    }

}

class Customer {
    private String Name;
    private String IdCard;
    private Hotel hotel;

    public Customer(String name, String idCard, Hotel hotel) {
        this(name, idCard);
        this.hotel = hotel;
    }

    public Customer() {
    }

    public Customer(String name, String idCard) {
        Name = name;
        IdCard = idCard;
    }

    public void showRoomInformation() {
        hotel.ShowInformathon();
    }

    public void CheckOutRoom(int Number) {
        hotel.CheckOut(Number);
    }

    public void BookARoom(int Number) {
        hotel.BookingRoom(Number);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getIdCard() {
        return IdCard;
    }

    public void setIdCard(String idCard) {
        IdCard = idCard;
    }
}
