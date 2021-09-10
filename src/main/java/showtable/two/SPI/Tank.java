package showtable.two.SPI;

public class Tank implements Moveable {
    @Override
    public void move() {
        System.out.println("坦克正在路上打仗...");
    }
}
