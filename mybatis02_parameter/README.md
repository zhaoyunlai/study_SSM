## MyBatis获取参数

### 两种方式：
1. `#{}`
2. `${}`

### 五种情况：
1. 若mapper接口方法的参数为单个的字面量类型
2. 若mapper接口方法的参数为多个的字面量类型
3. 若mapper接口方法的参数为一个map集合类型的参数
4. 若mapper接口方法的参数为实体类类型的参数
5. 可以在mapper接口方法的参数上设置@param注解

真正使用的就是两种情况：
*  1.使用注解（包括了情况1,2,3,5  这些情况下建议都用注解）
*  2.使用实体类对象，直接通过实体类属性获取值就可

--> com.zylai.mybatis.mapper.UserMapper

## 查询
1. 查询一个实体类对象
2. 查询一个集合
3. 查询为单个数据
4. 查询一条数据为map集合
5. 查询多条数据map集合
   两种方案：List封装，大的Map封装
   
--> com.zylai.mybatis.mapper.SelectMapper
   
## 特殊SQL执行

1. 模糊查询
2. 批量删除
3. 动态设置表名
4. 添加用户信息获取主键

--> SpecialSQLMapper.xml

