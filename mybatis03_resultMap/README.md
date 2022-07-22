## resultMap映射
### 1  处理字段和属性的映射关系

对于字段名和属性名不一致的情况，如何处理映射关系，有以下三种方式

1. 为查询的字段设置别名，和属性名保持一致 （一般不用）

2. 当字段符合mysql的要求使用_,而属性符合java要求使用驼峰
   此时可以在mybatis的核心配置文件中设置一个全局配置，
   可以自动将下划线映射为驼峰
   emp_id:empId,emp_name:empName
   
   -->mybatis-config.xml
   
3. 使用resultMap自定义处理映射 
   -->EmpMapper.xml

### 2 多对一映射处理
一个部门对应着多个员工，要查询完整的员工信息，就需要根据数据库中员工
所在部门的部门id查询到对应的部门信息。

三种方式
1. 级联查询  
   -->EmpMapper.xml
2. association  
   -->EmpMapper.xml
3. 分步查询  
   -->EmpMapper.xml DeptMapper

### 3 延迟加载
对于分步查询，关联的对象将会延迟加载。
比如获取emp信息，如果只是打印emp.getEmpName()，用不到Dept的信息
那么查询Dept的第二步将不会执行。

--> mybatis-config.xml

### 4 一对多映射处理
1. collection
2. 分步查询

-->DeptMapper.xml

