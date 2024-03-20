# 使用 RabbitMQ 的管理版本作为基础镜像
FROM rabbitmq:management

# 复制延迟消息插件到 RabbitMQ 插件目录
COPY ../../libs/rabbitmq_delayed_message_exchange-3.12.0.ez /opt/rabbitmq/plugins/
# 启用延迟消息插件
RUN rabbitmq-plugins enable rabbitmq_delayed_message_exchange
