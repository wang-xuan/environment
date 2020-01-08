package template;

/**
 * @Author:wx
 * @Date:2020/1/3 14:15
 */
public class GlassHouse extends HouseTemplate {
    @Override
    protected void buildWalls() {
        System.out.println("Building Glass Walls");
    }

    @Override
    protected void buildPillars() {
        System.out.println("Building Pillars with glass coating");
    }
}
