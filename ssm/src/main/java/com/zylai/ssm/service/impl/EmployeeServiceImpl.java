package com.zylai.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zylai.ssm.mapper.EmployeeMapper;
import com.zylai.ssm.pojo.Employee;
import com.zylai.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/01/20:58
 * @Description:
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


    @Override
    public List<Employee> getAllEmployee() {
        return employeeMapper.getAllEmployee();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeMapper.addEmployee(employee);
    }

    //分页查询
    @Override
    public PageInfo<Employee> getEmployeePage(Integer pageNum, Integer limit) {
        //开启分页功能
        PageHelper.startPage(pageNum,limit);
        //查询所有的员工信息
        List<Employee> list = employeeMapper.getAllEmployee();
        //获取分页相关数据
        PageInfo<Employee> pageInfo = new PageInfo<>(list,3);
        return pageInfo;
    }
}
