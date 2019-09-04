package com.itwx.environment.java8;

/**
 * @Author:wx
 * @Date:2019/8/29 15:32
 */
public class FormulaImpl implements Formula {
    @Override
    public double calculate(int a) {
        return Math.sqrt(a * 100);
    }
}
