package com.zylai.mybatis.mapper;

import com.zylai.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/22/17:09
 * @Description:
 */
public interface CacheMapper {

    /**
     * 根据员工id查询员工信息
     * @param empId 员工id
     * @return 员工信息
     */
    Emp getEmpById(@Param("empId") Integer empId);

    //添加
    void insertEmp(Emp emp);
}
