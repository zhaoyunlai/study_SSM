## Spring IOC 基于注解配置

### 1 获取bean的三种方式
--> com.zylai.spring.test.IOCByXMLTest
### 2 依赖注入
特殊值，各个类型的值如何注入
--> spring-ioc.xml
### 3 管理数据源和外部文件
--> spring-datasource.xml
    com.zylai.spring.test.DataSourceTest
### 4 bean的作用域
--> spring-scope.xml
    com.zylai.spring.test.ScopeTest
### 5 bean的生命周期
--> spring-lifecycle.xml
    com.zylai.spring.test.LifeCycleTest
    后置处理：com.zylai.spring.process.MyBeanPostProcessor
### 6 工厂bean
--> com.zylai.spring.test.FactoryTest
### 7 自动装配
--> com.zylai.spring.test.AutowireByXMLTest