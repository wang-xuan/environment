package decorate;

/**
 * @Author:wx
 * @Date:2020/1/4 15:57
 */
public class EggDecorate extends Decorate {
    public EggDecorate(AbstractBattercake abstractBattercake) {
        super(abstractBattercake);
    }

    @Override
    public String getDesc() {
        return super.getDesc() + "加一个鸡蛋 ";
    }


    @Override
    public int cost() {
        return super.cost() + 1;
    }
}
