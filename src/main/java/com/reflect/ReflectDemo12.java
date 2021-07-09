package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public class ReflectDemo12 {
    public static void main(String[] args) throws Exception{
        Class aClass = Class.forName("com.reflect.Myclass");
        Constructor[] Constructors = aClass.getDeclaredConstructors();

        StringBuffer strs = new StringBuffer();
        //public class Myclass {
        strs.append(Modifier.toString(aClass.getModifiers()) +" class "+aClass.getSimpleName()+" {\n");
        // public Myclass(String name, int age, double leght, long weight) {
        for (Constructor constructor:Constructors){
            strs.append("\t");
            strs.append(Modifier.toString(constructor.getModifiers()));
            strs.append(" ");
            strs.append("(");
            Class[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length>0){
                for (Class parameter:parameterTypes){
                    strs.append( parameter.getSimpleName());
                    strs.append(",");
                }
                strs.deleteCharAt(strs.length()-1);
                strs.append(")}\n");
            }else{
                strs.append(")}\n");
            }
            strs.append("}");
            System.out.println(strs);
        }
    }
}
