package observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:wx
 * @Date:2019/12/29 9:51
 *
 * 抽象目标类：汇率
 */
abstract class Rate {

    //将所有观察者子类或者实现类添加到集合中
    protected List<Company> companyList = new ArrayList<>();

    public void add(Company company) {
        companyList.add(company);
    }

    public void remove(Company company) {
        companyList.remove(company);
    }

    //子类实现该方法，并通知观察者
    public abstract void change(int number) ;
}
