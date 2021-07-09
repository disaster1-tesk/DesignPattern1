package hongchengstudy.work.savebookinfo;

import java.io.Serializable;

public class Book implements Serializable {
    private int no;
    private String name;
    private int price;
    private static final long serialVersionUID = 1L;
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Book(int no, String name, int price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
