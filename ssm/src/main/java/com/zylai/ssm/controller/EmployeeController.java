package com.zylai.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.zylai.ssm.pojo.Employee;
import com.zylai.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/01/18:42
 * @Description:
 *
 * 查询所有的员工信息-->/employee-->get
 * 查询员工的分页信息-->/employee/page/1-->get
 * 根据id查询某个员工信息-->/employee/1-->get
 * 跳转到添加页面-->/to/add-->get
 * 添加员工信息-->/employee-->post
 * 修改员工信息-->/employee-->put
 * 删除员工信息-->/employee/1-->delete
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public String getAllEmployee(Model model){
        //查询所有的员工信息
        List<Employee> employeeList = employeeService.getAllEmployee();
        //将员工信息在请求域中共享
        model.addAttribute("employeeList",employeeList);
        //跳转到employee_list.html
        return "employee_list";
    }

    @GetMapping("/employee/page/{pageNum}/{limit}")
    public String getEmployeePage(@PathVariable("pageNum") Integer pageNum,
                                  @PathVariable("limit") Integer limit,
                                  Model model){
        //获取员工的分页信息
        PageInfo<Employee> page = employeeService.getEmployeePage(pageNum,limit);
        //将分页的数据共享
        model.addAttribute("page",page);
        return "employee_list";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee){
        employeeService.addEmployee(employee);
        return "success";
    }
}
