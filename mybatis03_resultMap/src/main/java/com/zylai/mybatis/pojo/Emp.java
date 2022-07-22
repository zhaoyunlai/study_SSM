package com.zylai.mybatis.pojo;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/21/17:07
 * @Description:
 */
public class Emp {
    private Integer empId;

    private String empName;

    private String age;

    private String gender;

    private Dept dept;

    public Emp() {
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
