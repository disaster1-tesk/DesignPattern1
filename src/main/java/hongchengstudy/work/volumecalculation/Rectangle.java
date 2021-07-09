package hongchengstudy.work.volumecalculation;

public class Rectangle extends Polygon{
    protected int width;
    protected int length;


    public Rectangle(int height, int width, int length) {
        super(height);
        this.width = width;
        this.length = length;
    }

    @Override
    public double getArea() throws NumericalException {
        if (length<=0||width<=0){
            throw new NumericalException("数值有误！");
        }
        return (length*width);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", width=" + width +
                ", length=" + length +
                '}';
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
