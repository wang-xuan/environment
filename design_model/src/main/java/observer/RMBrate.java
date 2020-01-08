package observer;

/**
 * @Author:wx
 * @Date:2019/12/29 10:04
 *
 * 具体目标实现类 ： 人民币汇率
 */
public class RMBrate extends Rate {
    @Override
    public void change(int number) {
        //调用观察者中方法，即通知观察者变化
        for (Company company : companyList) {
            company.response(number);
        }
    }
}
