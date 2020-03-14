package main.java.reflect;

import javax.xml.bind.annotation.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;

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
        RefAccessibleObject.viewAnnotation();
        RefAccessibleObject.setAccessible();
    }

    public static void setAccessible() throws NoSuchFieldException {

        AccessibleObject privateField = RefAccessibleObject.class.getDeclaredField("privateField");
        AccessibleObject publicField = RefAccessibleObject.class.getDeclaredField("publicField");

        //eight: set Accessible
        privateField.setAccessible(true);

        //eight: set AccessibleObjects`s Accessible by static method
        AccessibleObject.setAccessible(new AccessibleObject[]{privateField,publicField},true);

    }

    public static void viewAnnotation() throws NoSuchFieldException {
        AccessibleObject privateField = RefAccessibleObject.class.getDeclaredField("privateField");



        //one: get all annotations (contain super class`s  annotations that can be inherited)
        Annotation[] annotations = privateField.getAnnotations();

        System.out.println("-----getAnnotations-----");
        for (Annotation annotation : annotations) {
            Class<? extends Annotation> aClass = annotation.annotationType();
            System.out.println(aClass);
        }
        System.out.println("-----getAnnotations-----");

        AccessibleObject publicField = ExtendRefAccessibleObject.class.getDeclaredField("publicField");

        //two: statement all annotations in the field
        Annotation[] declaredAnnotations = publicField.getDeclaredAnnotations();

        System.out.println("-----getDeclaredAnnotations-----");
        for (Annotation annotation : declaredAnnotations) {
            Class<? extends Annotation> aClass = annotation.annotationType();
            System.out.println(aClass);
        }
        System.out.println("-----getDeclaredAnnotations-----");

        //three: has contain annotation ?
        boolean hasXmlAnyElement = privateField.isAnnotationPresent(XmlAnyElement.class);

        if(hasXmlAnyElement){
            //four: user annotationType to get Annotation
            XmlAnyElement xmlAnyElement = privateField.getAnnotation(XmlAnyElement.class);

            //five: user annotationType to get DeclaredAnnotation
            XmlAnyElement declaredXmlAnyElement = privateField.getDeclaredAnnotation(XmlAnyElement.class);

            //six: user annotationType to get Annotations
            XmlAnyElement[] xmlAnyElements = privateField.getAnnotationsByType(XmlAnyElement.class);

            //seven: user annotationType to get DeclaredAnnotations
            XmlAnyElement[] declaredXmlAnyElements = privateField.getDeclaredAnnotationsByType(XmlAnyElement.class);
        }


    }



    public String getPrivateField() {
        return privateField;
    }

    public void setPrivateField(String privateField) {
        this.privateField = privateField;
    }

    public String getPublicField() {
        return publicField;
    }

    public void setPublicField(String publicField) {
        this.publicField = publicField;
    }


}
class ExtendRefAccessibleObject extends  RefAccessibleObject{

}