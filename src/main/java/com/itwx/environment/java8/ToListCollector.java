package com.itwx.environment.java8;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.stream.Collector.Characteristics.CONCURRENT;
import static java.util.stream.Collector.Characteristics.IDENTITY_FINISH;

/**
 * @Author:wx
 * @Date:2019/10/15 13:35
 *
 * Collector(T,A,R):
 * T:源数据流中元素的类型
 * A:中间的收集容器类型
 * R:返回的结果类型
 */
public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

    /**
     *1、创建新的结果容器
     */
    @Override
    public Supplier<List<T>> supplier() {
        //返回构造函数引用
        return ArrayList::new;
    }

    /**
     * 2、将元素添加到结果容器中
     * @return
     */
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    /**
     * 4、合并两个结果容器
     * @return
     */
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
        return list1; };
    }

    /**
     * 3、对结果容器做最终转换
     * @return
     */
    @Override
    public Function<List<T>, List<T>> finisher() {
        return  Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(IDENTITY_FINISH,CONCURRENT));
    }
}
