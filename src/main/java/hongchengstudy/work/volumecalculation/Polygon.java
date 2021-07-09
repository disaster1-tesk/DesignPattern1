package hongchengstudy.work.volumecalculation;

public abstract class Polygon {
    protected int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Polygon(int height) {
        this.height = height;
    }

    public abstract double getArea() throws NumericalException;

    @Override
    public String toString() {
        return "Polygon{" +
                "height=" + height +
                '}';
    }
}
