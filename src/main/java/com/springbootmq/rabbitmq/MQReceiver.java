package com.springbootmq.rabbitmq;


import com.rabbitmq.client.Channel;
import com.springbootmq.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MQReceiver {

		private static Logger log = LoggerFactory.getLogger(MQReceiver.class);
		
		@Autowired
		RedisService redisService;

		@RabbitListener(queues=MQConfig.DIRECT_QUEUE)
		public void receive(Message message, Channel channel) throws IOException {
			log.info("receive message:"+message);
			String messRegister = new String(message.getBody(), "UTF-8");
			channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
			System.out.println("接收到消息 receiveDirectMessage"+messRegister);
		}



//	@RabbitListener(queues=MQConfig)
//	public void receiveMiaoShaMessage(Message message, Channel channel) throws IOException {
//		log.info("接受到的消息为:{}",message);
//		String messRegister = new String(message.getBody(), "UTF-8");
//		channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
////		MiaoShaMessageVo msm  = RedisService.stringToBean(messRegister, MiaoShaMessageVo.class);
////		messageService.insertMs(msm);
//		System.out.println("接收到消息 "+messRegister);
//		}

	@RabbitListener(queues=MQConfig.TOPIC_QUEUE1)
	public void receiveTopMessage1(Message message, Channel channel) throws IOException {
		log.info("接受到的消息为:{}",message);
		String messRegister = new String(message.getBody(), "UTF-8");
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
//		MiaoShaMessageVo msm  = RedisService.stringToBean(messRegister, MiaoShaMessageVo.class);
//		messageService.insertMs(msm);
		System.out.println("接收到消息 receiveTopMessage1"+messRegister);
	}
	@RabbitListener(queues=MQConfig.TOPIC_QUEUE2)
	public void receiveTopMessage2(Message message, Channel channel) throws IOException {
		log.info("接受到的消息为:{}",message);
		String messRegister = new String(message.getBody(), "UTF-8");
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
//		MiaoShaMessageVo msm  = RedisService.stringToBean(messRegister, MiaoShaMessageVo.class);
//		messageService.insertMs(msm);
		System.out.println("接收到消息 receiveTopMessage2"+messRegister);
	}
}
