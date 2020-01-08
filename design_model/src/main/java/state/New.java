package state;

/**
 * @Author:wx
 * @Date:2019/12/27 21:04
 *
 * 具体状态类之一：新建线程状态
 */
public class New extends State {

    public void newThread() {
        threadState = "新建状态";
        System.out.println("当前线程处于：新建状态");
    }
}
