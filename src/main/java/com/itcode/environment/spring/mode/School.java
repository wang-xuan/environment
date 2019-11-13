package com.itcode.environment.spring.mode;

/**
 * @Author:wx
 * @Date:2019/11/13 10:11
 */
public class School {
    private String schoolName;
    private String address;
    private int studentNumber;
    /**byName：按照名字自动装配即 将与bean中[属性名字相同]的 其他[beanName]自动装配到该Bean对应的属性中
     * byType：按照属性类型装配即 将与bean中属性类型相同的 其他bean自动装配到该bean对应的属性中
     * */
    private Student studentByType;

    public String getSchoolName() {
        return schoolName;
    }
    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public int getStudentNumber() {
        return studentNumber;
    }
    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public Student getStudentByType() {
        return studentByType;
    }

    public void setStudentByType(Student studentByType) {
        this.studentByType = studentByType;
    }

    @Override
    public String toString() {
        return "School [schoolName=" + schoolName + ", address=" + address
                + ", studentNumber=" + studentNumber + "]";
    }
}
