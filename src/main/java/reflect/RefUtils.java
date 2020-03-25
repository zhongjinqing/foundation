package main.java.reflect;

import java.lang.reflect.Method;
import java.util.*;

/**
 * @author zjq
 * @date 2020/3/23 22:32
 */
public class RefUtils {

    /**
     * get different methods for two class
     * @param classes class
     * @return different methods
     */
    public static Collection<Method> getDiffMethods(Class<?> ... classes){
        //public methods:including those declared by the class or interface and those inherited from superclasses and superinterfaces.
        Method[] methods = classes[0].getMethods();
        Collection<Method> union = union(methods, new Method[]{});
        Collection<Method> objectSameMethod = getSameMethods(classes[0],Object.class);
        union.removeAll(objectSameMethod);
        for (Class<?> aClass : classes) {
            if (!classes[0].equals(aClass)){
                Collection<Method> sameMethod = getSameMethods(classes[0],aClass);
                union.removeAll(sameMethod);
            }
        }
        return union;


    }

    /**
     * get same methods for two class
     * @param objectClass class
     * @param otherObjectClass class
     * @return same methods
     */
    public static Collection<Method> getSameMethods(Class<?> objectClass, Class<?> otherObjectClass){
        //public methods:including those declared by the class or interface and those inherited from superclasses and superinterfaces.
        Method[] methods = objectClass.getMethods();
        Method[] methods3 = otherObjectClass.getMethods();
        ArrayList<Method> commonMethod = new ArrayList<>();
        for (Method method : methods) {
            for (Method method1 : methods3) {
                if(methodIsEquals(method,method1)){
                    commonMethod.add(method);
                }
            }
        }
        return commonMethod;

    }

    /**
     * return true if two method are same for name and parameterTypes
     * @param method1 method1
     * @param method2 method2
     * @return result
     */
    public static boolean methodIsEquals(Method method1, Method method2){
        return method1.getName().equals(method2.getName()) && Arrays.equals(method1.getParameterTypes(), method2.getParameterTypes());
    }

    /**
     *
     * @param arr1 methods
     * @param arr2 methods
     * @return union methods
     */
    public static Collection<Method> union(Method[] arr1, Method[] arr2) {
        Set<Method> set = new HashSet<Method>(Arrays.asList(arr1));
        Collections.addAll(set, arr2);
        return set;
    }

    /**
     * get all methods exclude object methods
     * @param objectClass class
     * @return class methods exclude object methods
     */
    public static Collection<Method> getMethods(Class<?> objectClass) {
        return getDiffMethods(objectClass,Object.class);
    }
}
