package main.java.reflect.common;


import javax.xml.bind.annotation.XmlValue;
import java.lang.reflect.AnnotatedElement;

/**
 * @author zjq
 * @date 2020/3/19 22:22
 */
public class AnnotatedElementMethod {

    @XmlValue
    private String field;
    public static void main(String[] args) {
        AnnotatedElement annotatedElement = getAnnotatedElement();
        //one:has the specified annotation ?
        boolean isHas = annotatedElement.isAnnotationPresent(XmlValue.class);
        System.out.println(isHas);

        if(isHas) {
            //two:return the specified annotation(contain inherited annotation),else null
            annotatedElement.getAnnotation(XmlValue.class);

            //three:return the specified annotation(directly present on this element Annotation),else null
            annotatedElement.getDeclaredAnnotation(XmlValue.class);
        }
        //four: get all Annotations (contain inherited annotations)
        annotatedElement.getAnnotations();

        //five: get directly present on this element Annotations
        annotatedElement.getDeclaredAnnotations();

        //six: get all Annotations for the specified annotation type
        annotatedElement.getAnnotationsByType(XmlValue.class);

        //seven: get all Annotations for directly present on this element
        annotatedElement.getDeclaredAnnotationsByType(XmlValue.class);


    }

    public static AnnotatedElement getAnnotatedElement(){
        AnnotatedElement annotatedElement = null;
        try {
            annotatedElement = AnnotatedElementMethod.class.getDeclaredField("field");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return annotatedElement;
    }

}
