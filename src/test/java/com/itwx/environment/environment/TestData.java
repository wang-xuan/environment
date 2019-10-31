package com.itwx.environment.environment;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 * @Author:wx
 * @Date:2019/10/30 19:55
 */
public class TestData {

    /**
     * 边界测试
     */
    @Test
    public void test01() {
        //单元边界测试
        String startTime = "00:00";
        String endTime = "3:00";

        boolean meet = true;
        StringBuilder stringBuilder = new StringBuilder();
        String time = stringBuilder.append(startTime).append("-").append(endTime).toString();
        Assert.isTrue(meet,"[" + time + "]" +" Meeting reservation fail");
    }


    /**
     * 单元测试：预定该时间段的会议室成功
     */
    @Test
    public void test02() {
        String startTime = "13:30";
        String endTime = "14:30";

        boolean meet = true;
        StringBuilder stringBuilder = new StringBuilder();
        String time = stringBuilder.append(startTime).append("-").append(endTime).toString();
        Assert.isTrue(meet,"[" + time + "]" +" Meeting reservation fail");
    }
}
