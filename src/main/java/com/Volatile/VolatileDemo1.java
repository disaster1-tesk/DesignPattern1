package com.Volatile;

public class VolatileDemo1 {
    private static int a=0,b=0;
    private static int x=0,y=0;
    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (true){
            i++;
          /*  a = 0;b = 0;
            x = 0;y = 0;*/
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    a=1;
                    x=b;
                }
            });
            Thread other = new Thread(new Runnable() {
                @Override
                public void run() {
                    b=1;
                    y=a;
                }
            });
            one.start();other.start();
            String result = "一共执行了"+i+"次："+"("+x+","+y+")";
            if (x==0  &&  y==0){
                System.out.println(result);
//                break;
            }else if((x==1  &&  y==0)||(x==1  &&  y==1)||(x==0  &&  y==1)){
                System.out.println(result);
            }
        }
    }
}
