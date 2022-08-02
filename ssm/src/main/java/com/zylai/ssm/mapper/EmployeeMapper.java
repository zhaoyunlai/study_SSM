package com.zylai.ssm.mapper;

import com.zylai.ssm.pojo.Employee;

import java.util.List;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/01/21:05
 * @Description:
 */
public interface EmployeeMapper {
    List<Employee> getAllEmployee();

    void addEmployee(Employee employee);
}
