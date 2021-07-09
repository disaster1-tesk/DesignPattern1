package hongchengstudy.work.bookmanager;

import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Book> bookList = new ArrayList<>();
        BookSys bookSys = new BookSys(bookList);
        while(true){
                System.out.println("===============欢迎来到disaster的图书管理系统=============");
                System.out.println("1.查询所有图书");
                System.out.println("2.添加图书");
                System.out.println("3.删除图书");
                System.out.println("4.查询一本图书");
                System.out.println("5.退出");
                System.out.println("请输入您想进行的操作：");
                int operation = scanner.nextInt();
                switch (operation){
                    case 1:
                        ArrayList<Book> all = bookSys.findAll();
                        for (Book book: all) {
                            System.out.println(book);
                        }
                        break;
                    case 2:
                        System.out.println("请输入您想添加的图书的编号：");
                        int bookId = scanner.nextInt();
                        System.out.println("请输入您想添加的图书的书名：");
                        String bookName = scanner.next();
                        System.out.println("请输入您想添加的图书的价格：");
                        int bookPrice = scanner.nextInt();
                        System.out.println("请输入您想添加的图书的作者：");
                        String bookAuthor = scanner.next();
                        System.out.println("请输入您想添加的图书的出版社：");
                        String bookPublisher = scanner.next();
                        Book book = new Book(bookId, bookName, bookPrice, bookAuthor, bookPublisher, false);
                        if (bookSys.add(book)){
                            System.out.println("添加图书"+book+"成功");
                        }else{
                            System.out.println("添加失败！！");
                        }
                        break;
                    case 3:
                        System.out.println("请输入您想删除书籍的编号：");
                        int bookId1 = scanner.nextInt();
                        if (bookSys.deleteBook(bookId1)){
                            System.out.println("删除成功！");
                        }else{
                            System.out.println("删除失败！");
                        }
                        break;
                    case 4:
                        System.out.println("请输入您想查询书籍的编号：");
                        int bookId2 = scanner.nextInt();
                        if (bookSys.find(bookId2)!=null){
                            System.out.println("查询成功!"+bookSys.find(bookId2));
                        }
                        break;
                    case 5:
                        bookSys.exit();
                        break;
                    default:
                        break;
                }
        }
    }
}
