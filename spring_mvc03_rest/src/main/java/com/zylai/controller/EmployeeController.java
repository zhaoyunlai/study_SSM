package com.zylai.controller;

import com.zylai.dao.EmployeeDao;
import com.zylai.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/30/11:27
 * @Description:
 * 查询所有的员工信息 -->/employee-->get
 * 跳转到添加页面 -->/to/add-->get
 * 新增员工信息 -->/employee-->post
 * 跳转到修改页面 -->/employee/1-->get
 * 修改员工信息 -->/employee-->put
 * 删除员工信息 -->/employee/1-->delete
 *
 */
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @GetMapping("/employee")
    public String getAllEmployee(Model model){
        //获取所有的员工信息
        Collection<Employee> employeeList = employeeDao.getAll();
        //将所有的员工信息在请求域中共享
        model.addAttribute("employeeList",employeeList);
        //跳转到列表页面
        return "employee_list";
    }

    @PostMapping("/employee")
    public String addEmployee(Employee employee){
        //保存员工信息
        employeeDao.save(employee);
        //访问列表功能，调用查询数据
        //重定向
        return "redirect:/employee";
    }

    @GetMapping("/employee/{id}")
    public String toUpdate(@PathVariable("id") Integer id,Model model){
        //根据id查询信息
        Employee employee = employeeDao.get(id);
        //将员工信息共享到请求域中
        model.addAttribute("employee",employee);
        //跳转
        return "employee_update";
    }

    @PutMapping("/employee")
    public String updateEmployee(Employee employee){
        //更新信息
        employeeDao.save(employee);
        //重定向
        return "redirect:/employee";
    }

    @DeleteMapping("/employee/{id}")
    public String deleteEmployeeById(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee";
    }

}
