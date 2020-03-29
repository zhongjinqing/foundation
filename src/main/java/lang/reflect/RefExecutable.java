package main.java.lang.reflect;

import main.java.lang.reflect.common.NotNull;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author zjq
 * @date 2020/3/27 17:32
 */
public class RefExecutable {

    public static void main(String[] args) {
        Collection<Method> diffMethods = RefUtils.getDiffMethods(Executable.class, AccessibleObject.class, Member.class);
        System.out.println(diffMethods.size());
        diffMethods.forEach(f-> System.out.println(f.getName()));

        Executable executable = getMethod();

        TypeVariable<?>[] typeParameters = executable.getTypeParameters();
        System.out.println(Arrays.toString(typeParameters));
        for (TypeVariable<?> typeParameter : typeParameters) {
            System.out.println(typeParameter.getName());
        }
        Class<?>[] parameterTypes = executable.getParameterTypes();
        System.out.println(Arrays.toString(parameterTypes));

        //对于executable的字符串描述
        //如：public static java.lang.String main.java.lang.reflect.RefExecutable.print(java.lang.String,java.lang.Integer)
        String s = executable.toGenericString();
        System.out.println(s);

        //返回参数的AnnotatedType类型的列表
        AnnotatedType[] annotatedParameterTypes = executable.getAnnotatedParameterTypes();
        for (AnnotatedType annotatedParameterType : annotatedParameterTypes) {
                System.out.println(annotatedParameterType.getType().getTypeName());
        }

        //获取executable抛出的异常类型
        System.out.println("------getGenericExceptionTypes-------");
        Type[] genericExceptionTypes = executable.getGenericExceptionTypes();
        for (Type genericExceptionType : genericExceptionTypes) {

            System.out.println(genericExceptionType.getTypeName());
        }
        //获取方法/构造器接收AnnotatedType
        System.out.println("------getAnnotatedReceiverType-------");
        AnnotatedType annotatedReceiverType = executable.getAnnotatedReceiverType();
        System.out.println(annotatedReceiverType);

        //获取方法/构造器接收参数个数
        System.out.println("------getParameterCount-------");
        int parameterCount = executable.getParameterCount();
        System.out.println(parameterCount);

        //获取方法/构造器参数
        System.out.println("------getParameters-------");
        Parameter[] parameters = executable.getParameters();
        for (Parameter parameter : parameters) {
            System.out.println(parameter.getType());
        }

        //获取形参注解
        System.out.println("------getParameterAnnotations-------");
        Annotation[][] parameterAnnotations = executable.getParameterAnnotations();
        System.out.println(Arrays.toString(parameterAnnotations));
        System.out.println(parameterAnnotations.length);
        for (Annotation[] annotations : parameterAnnotations) {
            System.out.println(Arrays.toString(annotations));
        }

        //获取方法/构造器返回值AnnotatedType
        System.out.println("------getAnnotatedReturnType-------");
        AnnotatedType annotatedReturnType = executable.getAnnotatedReturnType();
        System.out.println(annotatedReturnType.getType().getTypeName());

        //获取方法/构造器抛出异常信息Class格式
        System.out.println("------getExceptionTypes-------");
        Class<?>[] exceptionTypes = executable.getExceptionTypes();
        System.out.println(Arrays.toString(exceptionTypes));

        //获取方法/构造器抛出异常信息AnnotatedType格式
        System.out.println("------getAnnotatedExceptionTypes-------");
        AnnotatedType[] annotatedExceptionTypes = executable.getAnnotatedExceptionTypes();
        Arrays.asList(annotatedExceptionTypes).forEach(f-> System.out.println(f.getType().getTypeName()));

        //获取方法/构造器参数Type格式
        System.out.println("------getGenericParameterTypes-------");
        Type[] genericParameterTypes = executable.getGenericParameterTypes();
        Arrays.asList(genericParameterTypes).forEach(f-> System.out.println(f.getTypeName()));

        //获取方法/构造器参数是否包含可变长参数
        System.out.println("------isVar-------");
        boolean isVar = executable.isVarArgs();
        System.out.println(isVar);


    }

    public static Executable getMethod(){
        Executable executable = null;
        try {
            executable =  RefExecutable.class.getMethod("print", String.class, Integer[].class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return  executable;
    }
    public static String print(@NotNull String one, Integer... two) throws NullPointerException,NumberFormatException{
        return "one";
    }
}
