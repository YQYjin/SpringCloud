# SpringCloud
分布式SpringCloud项目

> YQY 2023.12.9
- 重置git,使子模块可以被父项目git统一管理并提交到github
- 完成了eureka注册中心
- 完成了provider服务提供者,成功将服务注册到eureka注册中心
- 将Spring Boot项目迁移到SpringCloud_Provider中,仅保留服务模块,移除其中的HTML资源和Spring Security模块
- 创建User服务使用者模块,成功完成三个模块的启动
- 使用test测试服务,成功实现User调用Provider提高的testController/springclod_test 服务,并返回数据

# 问题
- 使用负载均衡后不能再使用localhost访问,而要使用服务名访问
- 服务名中不能有下划线 _ 否则不能访问服务