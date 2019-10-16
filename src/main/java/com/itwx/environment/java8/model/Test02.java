package com.itwx.environment.java8.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author:wx
 * @Date:2019/10/8 14:04
 */
public class Test02 {

    /**
     * 实际上对流的操作就是filter-map-reduce
     * 对集合进行流式操作，实际上是通过Collect.stream()转化为Stream对象
     * @param args
     */
    public static void main(String[] args) {

       /* //构造流数据
        Stream stream = Stream.of("a","b","c");

        //将流数据转化为string类型
        String s = stream.collect(Collectors.joining()).toString();
        System.out.println(s);

        List strList = new ArrayList(3);
        strList.add("d");
        strList.add("e");
        strList.add("f");

        Stream strStream = strList.stream();
        strStream.collect(Collectors.toSet());*/

        List<String> asList = Arrays.asList("abs", "kld", "okls");
        List<String> list = asList.stream().map(e -> e.substring(0, 2)).collect(Collectors.toList());
        list.forEach(e -> System.out.println(e));

    }
}
