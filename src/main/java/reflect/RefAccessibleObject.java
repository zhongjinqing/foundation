package main.java.reflect;

import javax.xml.bind.annotation.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;

/**
 * to use java.lang.reflect.AccessibleObject
 * XmlElement/XmlAnyElement can`t be inherited
 * @author zjq
 * @date 2020/3/14 17:24
 */
public class RefAccessibleObject {

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
        RefAccessibleObject.setAccessible();
    }

    public static void setAccessible() throws NoSuchFieldException {

        AccessibleObject privateField = RefAccessibleObject.class.getDeclaredField("privateField");
        AccessibleObject publicField = RefAccessibleObject.class.getDeclaredField("publicField");

        //one: isAccessible()
        privateField.isAccessible();

        //two: set Accessible
        privateField.setAccessible(true);

        //three: set AccessibleObjects`s Accessible by static method
        AccessibleObject.setAccessible(new AccessibleObject[]{privateField,publicField},true);

    }

}