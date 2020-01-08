package decorate;

/**
 * @Author:wx
 * @Date:2020/1/4 15:54
 */
public class Decorate extends AbstractBattercake {

    private AbstractBattercake abstractBattercake;

    public Decorate(AbstractBattercake abstractBattercake) {
        this.abstractBattercake = abstractBattercake;
    }

    @Override
    public String getDesc() {
        return abstractBattercake.getDesc();
    }

    @Override
    public int cost() {
        return abstractBattercake.cost();
    }
}
