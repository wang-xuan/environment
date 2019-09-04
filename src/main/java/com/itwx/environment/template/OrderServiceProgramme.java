package com.itwx.environment.template;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @Author:wx
 * @Date:2019/9/4 14:12
 * 基于编程式事务实现转账业务
 */
public class OrderServiceProgramme {
    /**注入Dao层对象，在xml中，该类中注入对象属性*/
    private OrderDao orderDao;

    /**注入transactionTemplate对象*/
    private TransactionTemplate transactionTemplate;

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    /**
     * 转账业务
     */
    public void accountMoney() {
        transactionTemplate.execute(new TransactionCallback<Object>() {

            @Override
            public Object doInTransaction(TransactionStatus status) {
                Object result = null;
                try{
                    orderDao.addMoney();
                    //模拟中断操作
                    int i = 10 / 0;
                    orderDao.reduceMoney();
                } catch (Exception e) {
                    status.setRollbackOnly();
                    result = false;
                }
                return result;
            }
        });

    }
}
