package showtable.two.SPI;


import java.util.Iterator;
import java.util.ServiceLoader;

public class SPIDemo1 {
    public static void main(String[] args) {
        ServiceLoader<Moveable> load = ServiceLoader.load(Moveable.class);
        Iterator<Moveable> iterator = load.iterator();
        while (iterator.hasNext()){
            iterator.next().move();
        }
    }
}
