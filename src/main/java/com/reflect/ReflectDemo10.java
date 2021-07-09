package com.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectDemo10 {
    public static void main(String[] args) throws Exception{
        Class aClass = Class.forName("com.reflect.Myclass");
        //反编译方法
        StringBuffer strs = new StringBuffer();
        //public class Myclass {
        strs.append(Modifier.toString(aClass.getModifiers()) +" class "+aClass.getSimpleName()+" {\n");
        // public void dosomething(){
        Method[] Methods = aClass.getDeclaredMethods();
        for (Method method:Methods){
            strs.append("\t");
            strs.append(Modifier.toString(method.getModifiers()));
            strs.append(" ");
            strs.append(method.getReturnType().getSimpleName());
            strs.append(" ");
            strs.append(method.getName());
            strs.append("(");
            Class[] parameterTypes = method.getParameterTypes();
            if (parameterTypes.length>0){
                for (Class parameter:parameterTypes){
                    strs.append(parameter.getSimpleName());
                    strs.append(",");
                }
                strs.deleteCharAt(strs.length()-1);
                strs.append("){}\n");
            }else{
                strs.append("){}\n");
            }

        }
        strs.append("}");
        System.out.println(strs);
    }
}
