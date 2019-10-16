package com.itwx.environment.java8.model;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

/**
 * @Author:wx
 * @Date:2019/10/11 11:17
 */
public class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    private Currency currency;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    @Override
    public String toString() {
        return "{" + this.trader + ", " +
                "year: " + this.year + ", " +
                "value:" + this.value + "}";
    }

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
        //场景1：按照交易货币进行分组
        Map<Currency, List<Transaction>> transactionsByCurrencies = new HashMap<>(8);
        //原始方式
        for (Transaction transaction : transactions) {
            Currency currency = transaction.getCurrency();
            List<Transaction> transactionsForCurrency = transactionsByCurrencies.get(currency);
            if (transactionsForCurrency == null) {
                transactionsForCurrency = new ArrayList<>();
                transactionsByCurrencies.put(currency, transactionsForCurrency);
            }
            transactionsForCurrency.add(transaction);
        }

        //lambda 8分组:groupingBy映射成map按照给定谓词
        Map<String, List<Transaction>> currencyListMap = transactions.stream().collect(groupingBy(e -> e.getTrader().getName()));
        for (Map.Entry map : currencyListMap.entrySet()) {
            System.out.println(map.getKey() + map.getValue().toString());
        }

    }


}
