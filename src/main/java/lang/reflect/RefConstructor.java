package main.java.lang.reflect;


import java.lang.reflect.*;
import java.util.Collection;

/**
 * @author zjq
 * @date 2020/3/18 22:38
 */
public class RefConstructor {

    public String num;
    public RefConstructor(){

    }
    public RefConstructor(String num){
        this.num = num;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        getMethods();
        createInstance();
    }

    public static void getMethods(){
        Collection<Method> methods = RefUtils.getDiffMethods(Constructor.class, Executable.class);
        System.out.println(methods.size());
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

    /**
     * Constructor`method  is only newInstance  method
     */
    public static void  createInstance(){
        try {
            Constructor<RefConstructor> constructor = RefConstructor.class.getConstructor(String.class);
            //to create object
            RefConstructor refConstructor = constructor.newInstance("3");
            System.out.println(refConstructor.num);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
