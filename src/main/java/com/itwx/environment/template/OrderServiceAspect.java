package com.itwx.environment.template;

/**
 * @Author:wx
 * @Date:2019/9/4 14:36
 */
public class OrderServiceAspect {
    private OrderDao orderDao;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    /**
     * 转账业务
     */
    public void accountMoney() {
        orderDao.addMoney();
        //模拟中断操作
        int i = 10 / 0;
        orderDao.reduceMoney();
    }
}
