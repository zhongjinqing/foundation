package main.java.reflect.common;

/**
 * @author zjq
 * @date 2020/3/23 12:48
 */
public class ObjectMethod {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();

        //one: getClass
        Class<?> aClass = o.getClass();

        //two:equals
        boolean equalsResult = o.equals(new Object());

        //three: hashCode
        int i = o.hashCode();

        //four: toString
        String s = o.toString();

        //five:wait()/wait(long)/wait(long,int)
        o.wait(1);

        //six:notify
        o.notify();

        //seven:notifyAll
        o.notifyAll();
    }
}
