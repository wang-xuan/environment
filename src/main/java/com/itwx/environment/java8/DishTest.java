package com.itwx.environment.java8;

import com.itwx.environment.java8.model.CaloricLevel;
import com.itwx.environment.java8.model.Dish;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;

/**
 * @Author:wx
 * @Date:2019/10/11 10:54
 */
public class DishTest {
    @SuppressWarnings("unckecked")
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        //anyMatch：流程是否存在一个元素匹配给定的属性
       if (menu.stream().anyMatch( dish -> dish.getCalories() > 300)) {
           System.out.println("lll");
       }

       List numbers = Arrays.asList(1,2,1,3,3,2,4);
//        numbers.stream().distinct().forEach( e -> System.out.print(e));
        numbers.stream().distinct().forEach(System.out::print);

        String[] arrayOfWords = {"Goodbye", "World"};
        //将数组转化为流
        Stream<String> stream = Arrays.stream(arrayOfWords);
        stream.forEach(System.out::print);
        System.out.println();
        Optional<Dish> dish = menu.stream().filter(d -> d.getCalories() > 1000).findAny();
        System.out.println(dish.isPresent());

        System.out.println("==========================");

        long count = menu.stream().count();
        System.out.println("count =" + count);
        int size = menu.size();
        System.out.println("size=" + size);

        //计算最大热量
        menu.stream().map(dish1 -> dish1.getCalories()).reduce(Integer::max);
        Optional<Dish> dishOptional = menu.stream().reduce((t1, t2) -> t1.getCalories() > t2.getCalories() ? t1 : t2);
        dishOptional.ifPresent(e -> System.out.println(e.getName() + ":" + e.getCalories()));

        Comparator<Dish> dishComparator = Comparator.comparingInt(Dish::getCalories);
        Optional<Dish> maxCalories = menu.stream().collect(maxBy(dishComparator));
        maxCalories.ifPresent(e -> System.out.println(e.getName() + ":" + e.getCalories()));
        System.out.println("==============归约============");
        //汇总总热量
       int countCalories = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
        System.out.println("calories count : " + countCalories);

        //平均热量
        Double averageCalories = menu.stream().collect(Collectors.averagingDouble(Dish::getCalories));
        System.out.println("avetageCalories : " + averageCalories);

        //一次性得到元素个数、总和、平均数、最大值、最小值
        IntSummaryStatistics intSummaryStatistics = menu.stream().collect(Collectors.summarizingInt(Dish::getCalories));
        System.out.println(intSummaryStatistics);

        DoubleSummaryStatistics doubleSummaryStatistics = menu.stream().collect(Collectors.summarizingDouble(Dish::getCalories));
        System.out.println(doubleSummaryStatistics);

        //字符串连接：joining底层使用StringBuilder连接，重写toString 则不需要使用map提出菜单名
        String menuString = menu.stream().map(Dish::getName).collect(Collectors.joining());
        System.out.println(menuString);

        //按照特殊符号分割拼接字符串
        String menuName = menu.stream().map(Dish::getName).collect(Collectors.joining(","));
        System.out.println(menuName);

        System.out.println("=========使用广义上的归约汇总代替上面特殊案列=============");
        //Collectors.reducing()工厂方法
        Integer countReduce = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (t1, t2) -> t1 + t2));

        Optional<Dish> maxByReducing = menu.stream().collect(Collectors.reducing((t1, t2) -> t1.getCalories() > t2.getCalories() ? t1 : t2));

        //reduce单参数的返回是Optional<T>类型，获取值使用ifPresent或者Get()
        Integer countByOptionalGet = menu.stream().map(Dish::getCalories).reduce(Integer::sum).get();
        System.out.println(countByOptionalGet);

        System.out.println("==========分组========");
        Map<Dish.Type, List<Dish>> typeListMap = menu.stream().collect(groupingBy(Dish::getType));
        System.out.println(typeListMap);

        //按照卡路里高低不同分组
        Map<CaloricLevel, List<Dish>> ca = menu.stream().collect(groupingBy((Dish dish1) -> {
            if (dish1.getCalories() <= 400) {
                return CaloricLevel.DIET;
            } else if (dish1.getCalories() > 400 && dish1.getCalories() <= 700) {
                return CaloricLevel.NORMAL;
            } else {
                return CaloricLevel.FAT;
            }
        }));



    }

}
