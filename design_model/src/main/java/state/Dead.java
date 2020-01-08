package state;

/**
 * @Author:wx
 * @Date:2019/12/27 21:13
 */
public class Dead extends State {

    public void dead() {
        System.out.println("当前线程处于:死亡状态");
    }
}
