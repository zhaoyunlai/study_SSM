package com.zylai.ssm.service.impl;

import com.zylai.ssm.mapper.EmployeeMapper;
import com.zylai.ssm.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Zhao YunLai
 * @Date: 2022/08/01/20:58
 * @Description:
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;


}
