package com.zylai.mybatis.mapper;

import com.zylai.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/21/17:10
 * @Description:
 */
public interface EmpMapper {

    //测试处理字段和属性名不一致情况下的映射关系
    Emp getEmpByEmpId(@Param("empId") Integer empId);

    //连表查询员工和对应的部门的信息
    Emp getEmpAndDeptByEmpId(@Param("empId") Integer empId);

    //通过分步查询获取员工和部门的信息第一步
    Emp getEmpAndDeptByStepOne(@Param("empId") Integer empId);

    //通过分布查询获取部门信息和对应的员工信息第二步
    List<Emp> getDeptAndEmpByStepTwo(@Param("deptId") Integer deptId);
}
