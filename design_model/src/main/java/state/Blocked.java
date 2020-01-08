package state;

/**
 * @Author:wx
 * @Date:2019/12/27 21:12
 */
public class Blocked extends State {
    public void blocked() {
        System.out.println("当前线程处于:阻塞状态");
    }
}
