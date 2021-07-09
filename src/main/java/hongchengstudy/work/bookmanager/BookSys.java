package hongchengstudy.work.bookmanager;

import java.util.ArrayList;

public class BookSys {
    private ArrayList<Book> bookList;

    public BookSys(ArrayList<Book> bookList) {
        this.bookList = bookList;
        bookList.add(new Book(1001, "effect Java", 20, "约书亚·布洛克", "机械工业出版社", false));
        bookList.add(new Book(1002, "深入理解java虚拟机", 50, "周志明", "机械工业出版社", false));
        bookList.add(new Book(1003, "java并发编程实战", 45, "Brian Goetz", "机械工业出版社", false));
        bookList.add(new Book(1004, "java并发编程的艺术", 35, "方滕飞", "机械工业出版社", false));
        bookList.add(new Book(1005,"java编程思想", 80, "Bruce Eckel", "机械工业出版社", false));
    }

    //查询所有书籍
    public ArrayList<Book> findAll() {
        return bookList;
    }

    //添加图书
    public boolean add(Book book) {
        return bookList.add(book);
    }

    //删除图书
    public boolean deleteBook(int bookId) {
        for (Book book : bookList) {
            if (book.getBookId() == bookId) {
                bookList.remove(book);
                return true;
            }
        }
        return false;
    }

    //查询一本图书
    public Book find(int bookId) {
        for (Book book : bookList) {
            if (book.getBookId() == bookId) {
                if (book.getBookId() == bookId) {
                    return book;
                }
            }
        }
        return null;
    }

    //退出
    public void exit(){
        System.exit(0);
    }
}
