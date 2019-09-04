package com.itwx.environment.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author:wx
 * @Date:2019/8/29 11:43
 */
public class JavaTest {

    final static String salutation = "hello";
    public static void main(String[] args) {
//        Arrays.asList("a","b","c").forEach(e -> System.out.println(e));
//
//        String separator = ",";
//        Arrays.asList("q","n","m").forEach(e -> System.out.println(e + separator));
//
//        Formula formula = new FormulaImpl();
//        System.out.println(formula.calculate(4));
//        System.out.println(formula.sqrt(4));


        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        names.forEach(e -> System.out.println(e));
    }
}
