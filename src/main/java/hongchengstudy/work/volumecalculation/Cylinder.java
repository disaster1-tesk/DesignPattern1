package hongchengstudy.work.volumecalculation;

public class Cylinder extends Polygon {
    private int radius;

    public Cylinder(int height) {
        super(height);
    }

    public Cylinder(int height, int radius) {
        super(height);
        this.radius = radius;
    }

    @Override
    public double getArea() throws NumericalException {
        if (radius<=0){
            throw new NumericalException("数值有误！");
        }
        return (java.lang.Math.PI*(radius*radius));
    }

    @Override
    public String toString() {
        return "Cylinder{" +
                "radius=" + radius +
                ", height=" + height +
                '}';
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
