# 使用官方的Nginx镜像作为基础镜像
FROM nginx:latest

# 删除默认的Nginx配置文件
RUN rm /etc/nginx/conf.d/default.conf

# 将自定义的Nginx配置文件复制到容器中
COPY nginx.conf /etc/nginx/nginx.conf

# 暴露Nginx的80端口
EXPOSE 80
