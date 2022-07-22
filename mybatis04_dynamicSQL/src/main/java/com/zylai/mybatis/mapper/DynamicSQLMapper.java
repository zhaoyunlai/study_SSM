package com.zylai.mybatis.mapper;

import com.zylai.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/07/22/11:12
 * @Description:
 */
public interface DynamicSQLMapper {

    /**
     * 根据条件获取员工信息
     * @param emp 查询条件
     * @return 员工信息集合
     */
    List<Emp> getEmpByCondition(Emp emp);

    /**
     * 使用choose查询员工信息
     * @param emp 查询条件
     * @return 员工信息集合
     */
    List<Emp> getEmpByChoose(Emp emp);

    /**
     * 批量添加员工信息，如果这里不指定参数名称，那么mybatis会以list为键放到map中，获取参数时要以list获取
     * @param empList 员工信息列表
     */
    void insertBatchEmp(@Param("empList") List<Emp> empList);

    /**
     * 批量删除
     * @param empIds 员工id数组
     */
    void deleteBatchEmp(@Param("empIds") Integer[] empIds);
}
