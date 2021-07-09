package hongchengstudy.Lambda.v2;
/*
lambda表达式的省略写法规则：
1.当参数有且仅有一个时，可以省略（）
2.参数的数据类型可以省略
2.当实现中只有一条语句的时候，可以省略{}和return;
 */
public class Client {
    public static void main(String[] args) {
        /*invocation(5,8,(a,b)->{
             return a*b;
        });*/
        Calculate calculate = (a, b) -> a*b;
        invocation(5,1,calculate);
    }
    public static void invocation(int a,int b,Calculate calc){
        System.out.println("计算的结果为："+calc.Calc(a, b));
    }
}

interface Calculate {
    int Calc(int a, int b);
}