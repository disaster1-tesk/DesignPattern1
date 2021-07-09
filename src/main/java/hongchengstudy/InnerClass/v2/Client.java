package hongchengstudy.InnerClass.v2;


public class Client {
    public static void main(String[] args) throws NotFoundDirection {
        char[] chars = "MMRMMLMRRMLMMLMRRM".toCharArray();
        Tank tank = new Tank(11, 39);
        Order order = new Order(tank, "W");
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'M') {
                order.move();
            } else if (chars[i] == 'L') {
                order.turnLeft();
            } else if (chars[i] == 'R') {
                order.turnRight();
            }
        }
        System.out.println("("+tank.getX()+","+tank.getY()+")");
    }
}
