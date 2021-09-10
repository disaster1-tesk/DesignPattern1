package showtable.two;

import java.sql.SQLException;
import java.util.Iterator;

public class SQLExceptionDemo {
    public static void main(String[] args) {
        String[] strings = {"asdf","12"};
        main(strings);
       /* SQLException throwables = new SQLException();
        Iterator<Throwable> iterator = throwables.iterator();
        while (iterator.hasNext()){
            iterator.next().printStackTrace();
        }*/
    }
}
