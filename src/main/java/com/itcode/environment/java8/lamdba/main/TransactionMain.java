package com.itcode.environment.java8.lamdba.main;

import com.itcode.environment.java8.lamdba.model.Trader;
import com.itcode.environment.java8.lamdba.model.Transaction;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @Author:wx
 * @Date:2019/11/3 9:24
 */
public class TransactionMain {

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        transactions.stream().filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue)).collect(Collectors.toList())
                .forEach(transaction -> System.out.println(transaction.toString()));

        List<Trader> cambridge = transactions.stream().map(Transaction::getTrader).filter(trader1 -> trader1.getCity().equals("Cambridge")).distinct().sorted(Comparator.comparing(Trader::getName)).collect(Collectors.toList());
        cambridge.forEach(e -> System.out.println(e.getName()));

        //最大交易额
        Optional<Integer> reduce = transactions.stream().map(Transaction::getValue).reduce(Integer::max);

        reduce.ifPresent(e -> System.out.println("max value:" + e));

        Optional<Transaction> maxOptional = transactions.stream().reduce((t1, t2) -> t1.getValue() > t2.getValue() ? t1 : t2);
        maxOptional.ifPresent(e -> System.out.println(e.getValue()));
        //存在时返回值，否则会抛异常
        Transaction transactionObject = maxOptional.get();
        System.out.println("get max value:" + transactionObject.getValue());


        System.out.println("------------使用流收集数据--------------");
        //lambda 8分组:groupingBy映射成map按照给定谓词
        Map<String, List<Transaction>> currencyListMap = transactions.stream().collect(groupingBy(e -> e.getTrader().getName()));
        for (Map.Entry map : currencyListMap.entrySet()) {
            System.out.println(map.getKey() + map.getValue().toString());
        }

    }


}
