package disaster.company.Arithmetic;

import java.util.Objects;

public class ArithmeticDemo3 {
    public static void main(String[] args) {
        Tiger Maletiger = new Tiger(100);
        Tiger Tigress = new Tiger(101);
        int height = Maletiger.getHeight();
        int height1 = Tigress.getHeight();
        System.out.println(height>height1?height:height1);
        System.out.println(height>height1?true:false);
        System.out.println("两只老虎的体重是否一样？"+Maletiger.equals(Tigress));
    }

}
class Tiger{
    int height;
    public Tiger(int height){
        this.height = height;
    }
    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tiger tiger = (Tiger) o;
        return height == tiger.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}