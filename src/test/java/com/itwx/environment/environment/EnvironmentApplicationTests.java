package com.itwx.environment.environment;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DecimalFormat;
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




}

