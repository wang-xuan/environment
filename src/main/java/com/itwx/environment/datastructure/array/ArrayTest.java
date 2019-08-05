package com.itwx.environment.datastructure.array;

/**
 * @Author:wx
 * @Date:2019/6/22 20:14
 */
public class ArrayTest {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i ++){
            array.addLast(i);
        }
        System.out.println(array);
        array.addFirst(-1);
        System.out.println(array);
        array.set(1,20);
        System.out.println(array);
        array.add(3,30);
        System.out.println(array);

//        array.remove(1);
//        System.out.println(array);
//
//        array.removeElement(-1);
//        System.out.println(array);
    }
}
