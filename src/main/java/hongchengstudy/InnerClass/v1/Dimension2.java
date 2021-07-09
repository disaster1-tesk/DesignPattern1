package hongchengstudy.InnerClass.v1;

public class Dimension2 {
    private int X;
    private int Y;

    public Dimension2(int x, int y) {
        this.X = x;
        this.Y = y;
    }

    public Dimension2() {
    }

    public void getPost() {
        System.out.println("(" + this.X + "," + this.Y + ")");
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        this.X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        this.Y = y;
    }

    public static void main(String[] args) {
        new Dimension2(10,20).getPost();
    }
}
