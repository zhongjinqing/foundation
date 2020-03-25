package main.java.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;

/**
 * @author zjq
 * @date 2020/3/25 23:57
 */
public class RefField {
    public static void main(String[] args) {
        getMethods();
    }

    public static void getMethods(){
        Collection<Method> methods = RefUtils.getDiffMethods(Field.class, AccessibleObject.class);
        System.out.println(methods.size());
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
