package template;

/**
 * @Author:wx
 * @Date:2020/1/3 14:16
 */
public class Client {
    public static void main(String[] args) {
        HouseTemplate woodenHouse = new WoodenHouse();
        woodenHouse.buildHouse();

        System.out.println("-------------------");
        HouseTemplate glassHouse = new GlassHouse();
        glassHouse.buildHouse();
    }
}
