package state;

/**
 * @Author:wx
 * @Date:2019/12/27 21:17
 */
public class Client {
    public static void main(String[] args) {
        //外部客户端使用环境类访问
        Context context = new Context();
        //依赖状态，并创建其子类作为参数
        context.setState(new New());
        context.newThead();
    }
}
