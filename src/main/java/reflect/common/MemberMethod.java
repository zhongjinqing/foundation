package main.java.reflect.common;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

/**
 * @author zjq
 * @date 2020/3/20 12:26
 */
public class MemberMethod {

    private String field2;
    public volatile static String field;

    public static Member getFieldMember(){
        Member member = null;
        try {
            member = MemberMethod.class.getDeclaredField("field");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return member;
    }

    public static void main(String[] args) {
        Member fieldMember = getFieldMember();

        //one: return member`s class
        fieldMember.getDeclaringClass();

        //two: get member`s Modifiers
        // PUBLIC: 1
        //PRIVATE: 2
        //PROTECTED: 4
        //STATIC: 8
        //FINAL: 16
        //SYNCHRONIZED: 32
        //VOLATILE: 64
        //TRANSIENT: 128
        //NATIVE: 256
        //INTERFACE: 512
        //ABSTRACT: 1024
        //STRICT: 2048
        //64 + 8 + 1 = 73
        fieldMember.getModifiers();

        //three: the simple name of the underlying member
        fieldMember.getName();

        //four: the member was introduced by the compiler
        boolean synthetic = fieldMember.isSynthetic();
        System.out.println(synthetic);

        SubClass subClass = new MemberMethod().new SubClass();
        System.out.println(subClass.subParam1);
        System.out.println(subClass.subParam2);
        subClass.printMethodSub();
        for (Method method:subClass.getClass().getDeclaredMethods()){
            System.out.println("class name:"+subClass.getClass().getName()+"-"+       method.getName()+":"+method.isSynthetic());
        }

    }
    public class SubClass{
        private String subParam1;
        private String subParam2;
        public void printMethodSub(){
            System.out.println(MemberMethod.field);
            System.out.println("this is printMethodSub");
        }
    }
}
