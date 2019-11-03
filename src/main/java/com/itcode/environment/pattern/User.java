package com.itcode.environment.pattern;

/**
 * @Author:wx
 * @Date:2019/8/23 14:47
 * 建造者
 */
public class User {
    private String name;
    private String password;
    private String nickName;
    private Integer age;

    /**
     * 构造方法私有化，防止外部直接调用构造方法创建对象
     * @param name
     * @param password
     * @param nickName
     * @param age
     */
    private User(String name, String password, String nickName, Integer age) {
        this.name = name;
        this.password = password;
        this.nickName = nickName;
        this.age = age;
    }

    /**
     * 静态方法：用于创建构造者builder
     * @return
     */
    public static UserBuilder builder(){
        return new UserBuilder();
    }

   public  static class UserBuilder {
       private String name;
       private String password;
       private String nickName;
       private Integer age;

       private UserBuilder() {}

       /**
        * 链式调用设置各个属性值，返回this即UserBuilder
        */
       public UserBuilder name(String name) {
           this.name = name;
           return this;
       }

       public UserBuilder password(String password) {
           this.password = password;
           return this;
       }

       public UserBuilder nickName(String nickName) {
           this.nickName = nickName;
           return this;
       }

       public UserBuilder age(Integer age) {
           this.age = age;
           return this;
       }

       public User build() {
           return new User(name, password, nickName, age);
       }

   }

    public static void main(String[] args) {
        User user = User.builder().name("李四").password("1234567").nickName("ce").build();
        System.out.println(user.name);
    }

}
