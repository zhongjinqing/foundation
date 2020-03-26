package main.java.lang.reflect.common;


import javax.xml.bind.annotation.XmlValue;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.Arrays;

/**
 * @author zjq
 * @date 2020/3/19 22:22
 */
public class AnnotatedElementMethod extends Element{
    @XmlValue
    public static String field;
    public static void main(String[] args) {
        AnnotatedElement annotatedElement = getAnnotatedElement();
        //one:has the specified annotation
        boolean isHas = annotatedElement.isAnnotationPresent(NotNull.class);
        System.out.println(isHas);

        if(isHas) {
            //two:return the specified annotation(contain inherited annotation),else null
            annotatedElement.getAnnotation(NotNull.class);

            //three:return the specified annotation(directly present on this element Annotation),else null
            annotatedElement.getDeclaredAnnotation(XmlValue.class);
        }
        //four: get all Annotations (contain inherited annotations)
        Annotation[] annotations = annotatedElement.getAnnotations();
        Arrays.asList(annotations).forEach(f-> System.out.println(f.annotationType().getTypeName()));

        //five: get directly present on this element Annotations
        annotatedElement.getDeclaredAnnotations();

        //six: get all Annotations for the specified annotation type
        XmlValue[] annotationsByType = annotatedElement.getAnnotationsByType(XmlValue.class);

        //seven: get all Annotations for directly present on this element
        annotatedElement.getDeclaredAnnotationsByType(XmlValue.class);


    }

    public static AnnotatedElement getAnnotatedElement(){
        AnnotatedElement annotatedElement = null;
        try {
            annotatedElement = AnnotatedElementMethod.class.getField("field");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return annotatedElement;
    }

}
class Element{
    @NotNull
    public static String field;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        Element.field = field;
    }
}
