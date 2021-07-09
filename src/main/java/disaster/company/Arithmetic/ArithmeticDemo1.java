package disaster.company.Arithmetic;

public class ArithmeticDemo1 {
    public static void main(String[] args) {
        int i=10;
        int j =20;
        System.out.println((i++>100)&&(j++)>100);
        System.out.println(i);
        System.out.println(j);
        System.out.println("-------------");
        System.out.println((i++>100)||(j++)>100);
        System.out.println(i);
        System.out.println(j);
    }
}
