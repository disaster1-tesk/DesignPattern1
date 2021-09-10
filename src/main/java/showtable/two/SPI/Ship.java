package showtable.two.SPI;

public class Ship implements Moveable {
    @Override
    public void move() {
        System.out.println("船正在水上跑...");
    }
}
