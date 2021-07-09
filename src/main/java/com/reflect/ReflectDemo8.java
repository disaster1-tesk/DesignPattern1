package com.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
/*
结合反射机制来反编译代码！
 */
public class ReflectDemo8 {
    public static void main(String[] args) throws ClassNotFoundException {
        StringBuffer stringBuffer = new StringBuffer();
        Class aClass = Class.forName("java.lang.String");
        stringBuffer.append(Modifier.toString(aClass.getModifiers())+" class "+aClass.getSimpleName()+"{\n");
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field f:declaredFields){
            String s = Modifier.toString(f.getModifiers());
            String simpleName = f.getType().getSimpleName();
            String name = f.getName();
            stringBuffer.append("\t");
            stringBuffer.append(s);
            stringBuffer.append(" ");
            stringBuffer.append(simpleName);
            stringBuffer.append(" ");
            stringBuffer.append(name);
            stringBuffer.append(";");
            stringBuffer.append("\n");
        }
        stringBuffer.append("}");
        System.out.println(stringBuffer);
    }
}
