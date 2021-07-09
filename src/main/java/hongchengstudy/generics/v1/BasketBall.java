package hongchengstudy.generics.v1;

public class BasketBall extends Prizes{
    private String type;
    private int size;

    public BasketBall(String type, int size) {
        this.type = type;
        this.size = size;
    }

    @Override
    public String toString() {
        return "BasketBall{" +
                "type='" + type + '\'' +
                ", size=" + size +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
