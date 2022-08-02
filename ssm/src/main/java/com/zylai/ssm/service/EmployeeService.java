package com.zylai.ssm.service;

import com.github.pagehelper.PageInfo;
import com.zylai.ssm.pojo.Employee;

import java.util.List;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/01/20:58
 * @Description:
 */
public interface EmployeeService {
    List<Employee> getAllEmployee();

    void addEmployee(Employee employee);

    PageInfo<Employee> getEmployeePage(Integer pageNum, Integer limit);
}
