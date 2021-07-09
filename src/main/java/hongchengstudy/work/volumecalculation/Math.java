package hongchengstudy.work.volumecalculation;

public class Math<T> {
    public double getVolume(T t) throws NumericalException {
        Polygon polygon = null;
        if (t instanceof Cylinder){
            polygon = (Cylinder) t;
        }else if (t instanceof Rectangle){
            polygon = (Rectangle) t;
        }
        return polygon.getArea()*polygon.getHeight();
    }
}
