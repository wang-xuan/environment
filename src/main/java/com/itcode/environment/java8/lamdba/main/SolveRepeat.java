package com.itcode.environment.java8.lamdba.main;

import com.itcode.environment.java8.lamdba.model.Apple;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author:wx
 * @Date:2019/9/29 16:59
 */
public class SolveRepeat {
    public static void main(String[] args) {
        List<Apple> appleList = new LinkedList<>();
        Apple apple1 =  new Apple(1,"苹果1",new BigDecimal("3.25"),10);
        Apple apple12 = new Apple(1,"苹果2",new BigDecimal("1.35"),20);
        Apple apple2 =  new Apple(2,"香蕉",new BigDecimal("2.89"),30);
        Apple apple3 =  new Apple(3,"荔枝",new BigDecimal("9.99"),40);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);


        /**
         * 分组：List里面的对象元素，以某个属性来分组,key相同的放在一组，例如，以id分组，将id相同的放在一起；
         */
       /* Map<Integer, List<Apple>> appleIdMap = appleList.stream().collect(Collectors.groupingBy(Apple::getId));
        for (Map.Entry entry : appleIdMap.entrySet()) {
            List value = (List) entry.getValue();
            System.out.println(entry.getKey() + ",size:" + value.size());
        }*/


        /**
         * List转化为map
         * 方式1：考虑key存在重复情况,toMap 如果集合对象有重复的key，会报错Duplicate key ....,可以用 (k1,k2)->k1 来设置，如果有重复的key,则保留key1,舍弃key2
         * 方式2：确定key唯一
         */
       /* Map<Integer, Apple>  repeatIdMap= appleList.stream().collect(Collectors.toMap(Apple::getId, e -> e, (k1, k2) -> k1));
        for (Map.Entry entry : repeatIdMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }*/

        /**
         * 使用.map(T r)转换新的元素形式
         */
        List<Apple> list = appleList.stream().filter((Apple apple) -> apple.getName().startsWith("苹果")).map(Apple::new).collect(Collectors.toList());
        list.forEach(apple -> System.out.println(apple.getName() + apple.getMoney()));

//        appleList.remove(apple1);
//        Map<Integer, String> keyValueMap = appleList.stream().collect(Collectors.toMap(Apple::getId, Apple::getName));
//        for (Map.Entry entry : keyValueMap.entrySet()) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }

        /**
         * 过滤Filter
         * 从集合中过滤出来符合条件的元素：
         */
        /*List<Apple> filterList = appleList.stream().filter(a -> a.getName().equals("香蕉")).collect(Collectors.toList());
        System.out.println(filterList.get(0).getId() + ":" + filterList.get(0).getName());*/

        /*List<Apple> apples = appleList.stream().filter((Apple apple) -> (apple.getMoney().compareTo(new BigDecimal(3)) == 1)).collect(Collectors.toList());
        apples.forEach((Apple apple) -> System.out.println(apple.getName() + apple.getMoney()));*/
        /**
         *filter ：接受lambda表达式，按照条件将集合过滤；
         * map:接受lambda表达式，将元素转换为其他形式或者提取元素，所以List<T> T是String类型
         * collection ：将数据流转化为其他形式
         */
        List<String> appleMapToList = appleList.stream().filter((Apple apple) -> (apple.getMoney().compareTo(new BigDecimal(3)) == 1)).map(Apple::getName).collect(Collectors.toList());

//         System.out.println("----------去除重复元素------------");
        /**
         * 按照ID相同：去除集合中重复元素
         */
        /*List<Apple> uniqueList = appleList.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparingLong(Apple::getId))), ArrayList::new)
        );
        for (Apple apple : uniqueList) {
            System.out.println(apple.getId() + ":" + apple.getName());
        }
*/


        /**
         * set方式去除重复元素，不是new对象的方式
         */
       /* appleList.add(apple12);
        Set<Apple> appleSet = appleList.stream().collect(Collectors.toSet());
        for (Apple apple : appleSet) {
            System.out.println(apple.getId() + ":" + apple.getName());
        }*/

        /**
         * 按照stream流的方式去除重复
         * 通过流所生成元素的 hashCode() 和 equals() 去除重复元素。对象中重写equals和hashCode方法
         *
         * Stream<Apple> stream = appleList.stream();流式表达式，后缀加上.collect()将会转化为对应的集合
         */

        //创建一个与apple3内容相同的对象
        /*Apple apple31 = new Apple(3,"荔枝",new BigDecimal("9.99"),40);
        appleList.add(apple31);
        List<Apple> appleStream = appleList.stream().distinct().collect(toList());
        appleStream.forEach((Apple apple) -> {
            System.out.println(apple.getName());
        });*/




    }
}
