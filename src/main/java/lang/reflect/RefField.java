package main.java.lang.reflect;

import main.java.lang.reflect.common.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author zjq
 * @date 2020/3/25 23:57
 */
public class RefField {

    /**
     * one publicField
     */
    @NotNull
    public String publicField;

    private Integer privateMethod;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        getMethods();
        System.out.println("-------------");
        RefField refField = new RefField();
        System.out.println(refField.publicField);
        System.out.println(refField.privateMethod);
        setMethods(refField);
        System.out.println(refField.publicField);
        System.out.println(refField.privateMethod);
        System.out.println("-------------");
        refField.publicField = null;
        getMethods(refField);
        System.out.println("-------------");
        Field dayField = Day.class.getDeclaredField("MONDAY");
        //return true if class is enum class`s field,else false
        boolean enumConstant = dayField.isEnumConstant();
        System.out.println(enumConstant);
        System.out.println("-------------");
        Field publicField = RefField.class.getDeclaredField("publicField");
        //return field`s identifying class
        Class<?> type = publicField.getType();
        System.out.println("-------------");
        System.out.println(type);
        //return field`s name
        String name = publicField.getName();
        System.out.println(name);
        System.out.println("-------------");

        //get type of contain annotated
        AnnotatedType annotatedType = publicField.getAnnotatedType();
        System.out.println(annotatedType.getType().getTypeName());
        Annotation[] annotations = annotatedType.getAnnotations();
        Arrays.asList(annotations).forEach(f-> System.out.println(f.annotationType()));
        System.out.println("-------------");
        //get generic type
        Type genericType = publicField.getGenericType();
        System.out.println(genericType.getTypeName());


    }

    public static void getMethods(){
        Collection<Method> methods = RefUtils.getDiffMethods(Field.class, AccessibleObject.class, Member.class);
        System.out.println(methods.size());
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }

    public static void setMethods(RefField refField) throws NoSuchFieldException, IllegalAccessException {
        Field publicField = RefField.class.getField("publicField");
        //set byte、short、int、long、 float、double、boolean、char、object(omit)
        publicField.set(refField,"publicFieldValue");

        Field privateMethod = RefField.class.getDeclaredField("privateMethod");

        boolean accessible = privateMethod.isAccessible();
        System.out.println(accessible);
        //class can set it`s field whether or not accessible
        //class set other class`s field need keep accessible
        privateMethod.set(refField,3);
    }

    public static void getMethods(RefField refField) throws NoSuchFieldException, IllegalAccessException {
        Field publicField = RefField.class.getField("publicField");
        //set byte、short、int、long、 float、double、boolean、char、object(omit)
        Object o = publicField.get(refField);
        System.out.println(o);
    }

    public Integer getPrivateMethod() {
        return privateMethod;
    }

    public void setPrivateMethod(Integer privateMethod) {
        this.privateMethod = privateMethod;
    }
}
enum Day {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
