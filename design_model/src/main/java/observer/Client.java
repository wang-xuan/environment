package observer;

/**
 * @Author:wx
 * @Date:2019/12/29 10:06
 */
public class Client {
    public static void main(String[] args) {
        Rate rate = new RMBrate();

        Company importCompany = new ImportCompany();
        Company exportCompany = new ExportCompany();

        rate.add(importCompany);
        rate.add(exportCompany);
        rate.change(10);
    }
}
