package decorate;

/**
 * @Author:wx
 * @Date:2020/1/4 16:01
 */
public class SausageDecorate extends Decorate {

    public SausageDecorate(AbstractBattercake abstractBattercake) {
        super(abstractBattercake);
    }

    @Override
    public String getDesc() {
        return super.getDesc() + "加一个香肠 ";
    }

    @Override
    public int cost() {
        return super.cost() + 3;
    }
}
