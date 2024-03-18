# 使用官方的 OpenJDK 8 映像作为基础映像
FROM openjdk:8-jdk-alpine

# 设置工作目录
WORKDIR /app

# 将编译好的 Spring Boot JAR 文件复制到容器中的 /app 目录
COPY ../../target/SeckillDemo-0.0.1-SNAPSHOT.jar app.jar


# 在容器中运行 Spring Boot 应用程序
CMD ["java", "-jar", "app.jar"]
