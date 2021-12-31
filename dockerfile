# 基础镜像
FROM java:8
# author
MAINTAINER huni

# 挂载目录
VOLUME /home/laji
# 创建目录
RUN mkdir -p /home/laji
# 指定路径
WORKDIR /home/laji
# 复制jar文件到路径
COPY ./*.jar /home/laji/laji.jar
# 启动应用
ENTRYPOINT ["java","-jar","laji.jar"]

