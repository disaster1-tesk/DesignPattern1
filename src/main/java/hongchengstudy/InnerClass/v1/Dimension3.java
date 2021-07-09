package hongchengstudy.InnerClass.v1;

public class Dimension3 extends Dimension2 {
    private int z;

    public Dimension3(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public Dimension3(int z) {
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public void getPost() {
        super.getPost();
        System.out.println("(" + super.getX() + "," + super.getY() + "," + this.z + ")");
    }

    public static void main(String[] args) {
        new Dimension3(10, 20, 30).getPost();
    }
}
