package com.itwx.environment.quartz;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author:wx
 * @Date:2019/9/11 16:15
 */
public class TestQuartz {
    public void run() {
        System.out.println(new SimpleDateFormat("任务执行了" + "yyyy-MM-dd HH:mm:ss").format(new Date()));
    }
}
