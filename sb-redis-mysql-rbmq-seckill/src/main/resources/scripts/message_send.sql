CREATE TABLE message_send (
      id INT AUTO_INCREMENT PRIMARY KEY,
      username INT NOT NULL,
      stock_name VARCHAR(255) NOT NULL,
      status VARCHAR(20) NOT NULL DEFAULT '待处理',
      create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
      update_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);



# 消息ID：唯一标识每条消息的ID。
# 消息内容：包含要发送的消息内容。
# 消息状态：记录消息的当前状态，例如待处理、已发送、发送失败等。
# 创建时间：记录消息创建的时间。
# 更新时间：记录消息状态更新的时间。
# 其他字段：根据实际需要，可以添加一些其他字段，例如重试次数、消息类型等。
# 根据您的需求，在生产者发送消息前，先将消息写入消息发送表，状态设为待处理。然后生产者发送MQ消息。消费者消费消息后，处理完业务逻辑后，回调生产者的接口，更新消息状态为已处理。
#
# 具体实现步骤如下：
#
# 创建消息发送表，包含上述字段。
# 在生产者发送MQ消息前，先将消息写入消息发送表，状态设为待处理。
# 生产者发送MQ消息。
# 消费者消费消息后，处理完业务逻辑后，调用生产者的接口，更新消息状态为已处理。