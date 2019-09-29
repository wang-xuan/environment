package com.itwx.environment.environment;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EnvironmentApplicationTests {

    @Test
    public void contextLoads() {
        int x=2,y=5,k=0;
        switch(x%y){
            case 0: k=x+y;
//            break;
            case 2: k=x*y;
            case 1: k=x-y;
//            break;

//            break;
//            default:k=x/y;
//            break;
        }
        System.out.println("k="+k);
    }

    @Test
    public void test01(){
        double x= 1234.1234567;
        DecimalFormat form = new DecimalFormat("0.00");
        System.out.println(form.format(x));
        String str = "javaokl";
        System.out.println("Str="+str.substring(1,4));
    }

    @Test
    public void test03(){
        for(int i = 1; i <= 9; i++ ){
            for(int j = 1; j <= i; j++ ){
                System.out.print(j+"*"+i+"="+i*j+" ");
            }
            System.out.println(" ");
        }
    }

    @Test
    public void test04(){
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        for(int i = 2; i <= x; i++){
            //素数即除1和自身之外，没有其他因子
            if ((i % x) == 0 && (i!= x)){
                System.out.println("不是素数");
            }else {
                System.out.println("是素数");
            }
        }
    }


    @Test
    public void test05() {
        Map<String, Object> row1 = new LinkedHashMap<>();
        row1.put("姓名", "张三");
        row1.put("年龄", 23);
        row1.put("成绩", 88.32);
        row1.put("是否合格", true);
        row1.put("考试日期", DateUtil.date());

        Map<String, Object> row2 = new LinkedHashMap<>();
        row2.put("姓名", "李四");
        row2.put("年龄", 33);
        row2.put("成绩", 59.50);
        row2.put("是否合格", false);
        row2.put("考试日期", DateUtil.date());

        ArrayList<Map<String, Object>> rows = CollUtil.newArrayList(row1, row2);

        // 通过工具类创建writer
        ExcelWriter writer = ExcelUtil.getWriter("d:/writeMapTest.xlsx");
// 合并单元格后的标题行，使用默认标题样式
        writer.merge(row1.size() - 1, "一班成绩单");
// 一次性写出内容，使用默认样式
        writer.write(rows);
// 关闭writer，释放内存
        writer.close();
    }



}

