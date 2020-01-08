package template;

/**
 * @Author:wx
 * @Date:2020/1/3 14:02
 *
 * 建房子模板类
 */
public abstract class HouseTemplate {

    /**
     *创建不允许子类的实现的模板方法,所以可以使用final修饰
     */
    public final void buildHouse() {
        //第一步：建造地基
        buildFoundation();
        //第二步：建造支撑
        buildPillars();
        //第三步：建造墙体
        buildWalls();
        //第四步：建造窗口
        buildWindows();
    }


    //-----创建可以由子类实现的基本方法


    /**
     * 建造窗口
     */
    protected void buildWindows() {
        System.out.println("building windows");
    }

    /**
     * 建造墙体
     */
    protected abstract void buildWalls();

    /**
     * 建造支撑
     */
    protected abstract void buildPillars();

    /**
     * 建造地基
     */
    protected void buildFoundation() {
        System.out.println("Building foundation with cement, iro rods and sand");
    }

}
