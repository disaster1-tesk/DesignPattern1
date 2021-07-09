package com.high.Example;
/*
编写程序，使用一维数组，模拟栈数据结构。
    要求、
        1.这个栈可以存储java中的任何引用类型的数据。
        2.在栈中提供push方法模拟压栈（栈满了，要有提示信息。）
        3.在栈中提供pop方法模拟弹栈（栈空了，也要有提示信息。）
        4.编写测试程序，new栈对线，调用push pop方法来模拟压栈弹栈的动作
 */
public class Example4 {
    public static void main(String[] args) {
        Object[] objects = {1,2,3,4,5};
        Mystack mystack = new Mystack(objects);
        mystack.push(1);
        mystack.push(1);
        mystack.pop();
        mystack.push(1);
        mystack.push(1);
    }
}
class Mystack{
    private Object[] objects;
    private int index;
    public Mystack(Object[] objects) {
        this.objects = objects;
        for (int i = 0; i <this.objects.length-1 ; i++) {
            if (this.getObjects()[i]==null){
                this.index=i;
                break;
            }else{
                this.index=this.objects.length-1;
            }
        }
    }
    /*
    压栈方法
     */
    public Boolean push(Object objects){
        if (this.getObjects().length<0||this.getIndex()>=this.getObjects().length-1){
            System.out.println("栈已满，无法再继续压栈！");
            return false;
        }
        index++;
        this.getObjects()[index]=objects;
        System.out.println("压栈成功！");
        return true;
    }
    /*
    出栈方法
     */
    public Boolean pop(){
        if (this.getObjects().length<0||this.getIndex()>this.getObjects().length-1||this.getIndex()==0){
            System.out.println("栈中没有数据了，无法出栈！");
            return false;
        }
        this.getObjects()[index]=null;
        index--;
        System.out.println("出栈成功！");
        return true;
    }
    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
