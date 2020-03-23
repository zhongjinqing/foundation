package main.java.reflect.common;

import main.java.reflect.RefUtils;

import javax.xml.bind.annotation.*;
import java.lang.reflect.*;
import java.util.*;

/**
 * to use java.lang.reflect.AccessibleObject
 * XmlElement/XmlAnyElement can`t be inherited
 * @author zjq
 * @date 2020/3/14 17:24
 */
public class AccessibleObjectMethod {

    /**
     * get privateField as AccessibleObject
     */
    @XmlElement
    @XmlAnyElement
    private String privateField;

    /**
     * get publicField as AccessibleObject
     */
    @XmlID
    public String publicField;


    public static void main(String[] args) throws NoSuchFieldException {
        Collection<Method> sameMethod = RefUtils.getSameMethods(AccessibleObject.class,AnnotatedElement.class);
        for (Method o : sameMethod) {
            System.out.println(o.getName());
        }
        Collection<Method> diffMethod = RefUtils.getDiffMethods(AccessibleObject.class,AnnotatedElement.class);
        System.out.println("---------------");
        for (Method o : diffMethod) {
            System.out.println(o.getName());
        }
        System.out.println("---------------");
        Collection<Method> methods = RefUtils.getMethods(AnnotatedElement.class);
        for (Method method : methods) {
            System.out.println(method.getName());
        }


    }

    public static void setAccessible() throws NoSuchFieldException {

        AccessibleObject privateField = AccessibleObjectMethod.class.getDeclaredField("privateField");
        AccessibleObject publicField = AccessibleObjectMethod.class.getDeclaredField("publicField");

        //one: isAccessible()
        privateField.isAccessible();

        //two: set Accessible
        privateField.setAccessible(true);

        //three: set AccessibleObjects`s Accessible by static method
        AccessibleObject.setAccessible(new AccessibleObject[]{privateField,publicField},true);

    }







}