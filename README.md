# SpringCloud
分布式SpringCloud项目
## 项目结构
- 项目分为父项目:SpringCloud和三个子模块:SpringCloud_Provider,SpringCloud_User,SpringCloud_Eureka
- 子模块不创建git仓库,由父项目统一管理
- 首次拉取时,在各子模块的pom.xml文件中右键,将该模块设置为Maven项目
- HTML资源由User控制,Provider仅注重于API的提供

> YQY 2023.12.9
- 重置git,使子模块可以被父项目git统一管理并提交到github
- 完成了eureka注册中心
- 完成了provider服务提供者,成功将服务注册到eureka注册中心
- 将Spring Boot项目迁移到SpringCloud_Provider中,仅保留服务模块,移除其中的HTML资源和Spring Security模块
- 创建User服务使用者模块,成功完成三个模块的启动
- 使用test测试服务,成功实现User调用Provider提高的testController/springclod_test 服务,并返回数据

> YQY 2023.12.10
- 将HTML资源迁移到SpringCloud_User模块中
- 添加视图控制器
- 修改StaffController,使其向服务提供者获取获取服务,
- 服务提供者默认返回xml格式,在@XXXMapping注解中添加produces = "application/json"使其返回json格式
- 修改前端,使用json.parse解析User返回的json字符串
- 修改User,将原Controller中的方法改为向Provider获取服务
- 未进行测试



# 问题

- 使用负载均衡后不能再使用localhost访问,而要使用服务名访问
- 服务名中不能有下划线 _ 否则不能访问服务