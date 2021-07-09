package com.high.TostringAndEquals;

import java.util.Objects;

public class Demo1 {
    public static void main(String[] args) {
        User user1 = new User("Disaster",new Address("湖南","斗笠山","101"));
        User user2 = new User("Disaster",new Address("湖南","斗笠山","101"));
        System.out.println(user1.equals(user2));
    }
}

class User {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(Name, user.Name) &&
                Objects.equals(Addr, user.Addr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Addr);
    }

    @Override
    public String toString() {
        return "User{" +
                "Name='" + Name + '\'' +
                ", Addr=" + Addr +
                '}';
    }

    private String Name;
    private Address Addr;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Address getAddr() {
        return Addr;
    }

    public void setAddr(Address addr) {
        Addr = addr;
    }

    public User() {
    }

    public User(String name, Address addr) {
        Name = name;
        Addr = addr;
    }
}

class Address {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(City, address.City) &&
                Objects.equals(Street, address.Street) &&
                Objects.equals(DoorNumber, address.DoorNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(City, Street, DoorNumber);
    }

    @Override
    public String toString() {
        return "Address{" +
                "City='" + City + '\'' +
                ", Street='" + Street + '\'' +
                ", DoorNumber='" + DoorNumber + '\'' +
                '}';
    }

    private String City;
    private String Street;
    private String DoorNumber;

    public Address() {
    }

    public Address(String city, String street, String doorNumber) {
        City = city;
        Street = street;
        DoorNumber = doorNumber;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getDoorNumber() {
        return DoorNumber;
    }

    public void setDoorNumber(String doorNumber) {
        DoorNumber = doorNumber;
    }
}
