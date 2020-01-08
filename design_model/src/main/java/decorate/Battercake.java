package decorate;

/**
 * @Author:wx
 * @Date:2020/1/4 15:53
 */
public class Battercake extends AbstractBattercake {
    @Override
    public String getDesc() {
        return "煎饼 ";
    }

    @Override
    public int cost() {
        return 8;
    }
}
