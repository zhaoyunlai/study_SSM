## SSM整合

整体思路：
1. web.xml是所有配置的入口
2. 在web.xml中通过设置DispatcherServlet指定了SpringMVC的配置文件
3. 在web.xml中设置Spring的监听器指定了Spring的配置文件
4. 在Spring的配置文件中设置SqlSessionFactoryBean指定了Mybatis的配置文件