package decorate;

/**
 * @Author:wx
 * @Date:2020/1/4 16:02
 */
public class Client {
    public static void main(String[] args) {
        AbstractBattercake battercake = new Battercake();
        battercake = new EggDecorate(battercake);
        battercake = new EggDecorate(battercake);
        battercake = new SausageDecorate(battercake);
        System.out.println(battercake.getDesc() + " 价格：" + battercake.cost());
    }
}
