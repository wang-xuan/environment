package template;

/**
 * @Author:wx
 * @Date:2020/1/3 14:13
 */
public class WoodenHouse extends HouseTemplate {
    @Override
    protected void buildWalls() {
        System.out.println("Building Wooden Walls");
    }

    @Override
    protected void buildPillars() {
        System.out.println("Building Pillars with Wood coating");
    }
}
