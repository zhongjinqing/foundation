package main.java.lang.reflect;

/**
 * to use reflect
 * main method
 *  1.get/set object array value
 *  2.get/set base data types
 *  3.newInstance
 *      param0:type;
 *      param1:one-dimensional length
 *      param2:two-dimensional length
 *      paramN:N-dimensional length
 * @author zjq
 * @date 2020/2/23 22:22
 */
public class RefArray {

    public static void main(String[] args) {
        boolean[] arr = new boolean[10];
        arr[0] = false;
        boolean o = (boolean) java.lang.reflect.Array.get(arr, 1);
        System.out.println(o);

        boolean aBoolean = java.lang.reflect.Array.getBoolean(arr, 1);
        System.out.println(aBoolean);

        int[] x = (int[]) java.lang.reflect.Array.newInstance(int.class,100);
        java.lang.reflect.Array.setInt(x,99,199);
        int anInt = java.lang.reflect.Array.getInt(x, 99);

        float[][][] floatArr = (float[][][]) java.lang.reflect.Array.newInstance(float.class, 10, 3,4);

        System.out.println(floatArr[0].length);
        System.out.println(floatArr[0][0].length);
        System.out.println(floatArr[0][0][0]);
    }
}
