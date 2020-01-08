package state;

/**
 * @Author:wx
 * @Date:2019/12/27 21:14
 *
 * 环境类
 */
public class Context {

    private State state;

    public void setState(State state) {
        this.state = state;
    }
    public void newThead() {
        System.out.println(state.threadState);
    }
}
