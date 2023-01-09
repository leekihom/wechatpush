# 拉取jdk8作为基础镜像
FROM openjdk:8
# 作者
MAINTAINER leezihong
# 添加时区环境变量，亚洲，上海
ENV TimeZone=Asia/Shanghai
# 使用软连接，并且将时区配置覆盖/etc/timezone
RUN ln -snf /usr/share/zoneinfo/$TimeZone /etc/localtime && echo $TimeZone > /etc/timezone
# 添加jar到镜像并命名为user.jar
ADD wechatpush.jar wechatpush.jar
# 镜像启动后暴露的端口
EXPOSE 8081
# jar运行命令，参数使用逗号隔开
ENTRYPOINT ["java","-jar","wechatpush.jar"]