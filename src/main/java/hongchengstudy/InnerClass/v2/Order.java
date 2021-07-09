package hongchengstudy.InnerClass.v2;

public class Order {
    Tank tank;
    String startDirection;
    public Order(Tank tank) {
        this.tank = tank;
    }

    public Order(Tank tank, String startDirection) {
        this.tank = tank;
        this.startDirection = startDirection;
    }

    public String getStartDirection() {
        return startDirection;
    }

    public void setStartDirection(String startDirection) {
        this.startDirection = startDirection;
    }
    //左转向
    public void turnLeft() throws NotFoundDirection{
        turnDirection("S", "N");
    }
    //右转向
    public void turnRight() throws NotFoundDirection{
        turnDirection("N", "S");
    }

    private void turnDirection(String n, String s) throws NotFoundDirection {
        if (startDirection.equals("W")){
            setStartDirection(n);
        }else if (startDirection.equals(n)){
            setStartDirection("E");
        }else if(startDirection.equals("E")){
            setStartDirection(s);
        }else if (startDirection.equals(s)){
            setStartDirection("W");
        }else{
            throw new NotFoundDirection("方向不属于规定的中的其中一个方向");
        }
    }

    //前进
    public void move(){
        if (getStartDirection().equals("W")){
            tank.setX(tank.getX()-1);
        }else if (getStartDirection().equals("E")){
            tank.setX(tank.getX()+1);
        }else if (getStartDirection().equals("S")){
            tank.setY(tank.getY()-1);
        }else if (getStartDirection().equals("N")){
            tank.setY(tank.getY()+1);
        }
    }
}
