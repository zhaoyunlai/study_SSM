package com.zylai.mybatis.mapper;

import com.zylai.mybatis.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/21/19:34
 * @Description:
 */
public interface DeptMapper {

    //通过分步查询获取员工和部门的信息第二步
    Dept getEmpAndDeptByStepTwo(@Param("deptId")Integer deptId);

    //查询部门信息以及该部门的所有员工
    Dept getDeptAndEmpByDeptId(@Param("deptId")Integer deptId);

    //通过分布查询获取部门信息和对应的员工信息第一步
    Dept getDeptAndEmpByStepOne(@Param("deptId")Integer deptId);
}
