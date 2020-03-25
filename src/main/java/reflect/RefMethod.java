package main.java.reflect;

import javax.xml.bind.annotation.XmlValue;
import java.lang.reflect.*;
import java.util.Collection;

/**
 * @author zjq
 * @date 2020/3/26 0:18
 */
public class RefMethod {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        getMethods();

        //one:isBridge
        AClass obj = new AClass();
        Collection<Method> methods = RefUtils.getMethods(AClass.class);
        for (Method method : methods) {
            System.out.println(method.getName()+":"+method.isBridge());
            //two：i don`t know
            System.out.println(method.getDefaultValue());
        }
        Method method = AClass.class.getMethod("func",String.class);
        //three:to exe method
        method.invoke(obj,"aaa");

        //four:get return Type,ex:int
        Type genericType = method.getGenericReturnType();
        System.out.println(genericType.getTypeName());

        //five:get return class
        Class<?> classType = method.getReturnType();
        System.out.println(classType.getTypeName());

        //six:return true if method  is interface`s default method
        Method defaultMethod = AClass.class.getMethod("defaultMethod");
        boolean aDefault = defaultMethod.isDefault();
        System.out.println(aDefault);
    }
    public static void getMethods(){
        Collection<Method> methods = RefUtils.getDiffMethods(Method.class, Executable.class);
        System.out.println(methods.size());
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

}
interface AInterface<T>{
    default String defaultMethod(){
        return "2";
    }
    /**
     * no
     * @param t t
     */
    String func(T t);
}
class AClass implements AInterface<String> {
    @Override
    @XmlValue
    public String func(String s) {
        System.out.println(s);
        return "1";
    }

}
