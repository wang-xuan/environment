package com.itwx.environment.thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author:wx
 * @Date:2019/10/31 14:44
 */
public class FinalDemo {

    private static final String name = "小明";

    private static final Integer age = 12;

    private static Map<String, Object> map = new HashMap<>();

    static {
        map.put("name","小明");
        map.put("age",12);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put("name","小");
        System.out.println(map.get("name"));
    }
}
