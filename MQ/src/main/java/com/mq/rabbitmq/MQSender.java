package com.mq.rabbitmq;

import com.mq.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQSender {

	private static Logger log = LoggerFactory.getLogger(MQSender.class);
	
	@Autowired
	AmqpTemplate amqpTemplate ;

	@Autowired
	private RabbitTemplate rabbitTemplate;
	/**
	 * 普通消息
	 * @param mm
	 */
	public void sendDirectMessage(MyMessage mm) {
		String msg = RedisService.beanToString(mm);
		log.info("send message:"+msg);
		amqpTemplate.convertAndSend(MQConfig.DIRECT_QUEUE, msg);
	}

	/**
	 * Topic
	 * @param mm
	 */
	public void sendTopicMessage(MyMessage mm) {
		String msg = RedisService.beanToString(mm);
		log.info("send message:"+"11111");
		rabbitTemplate.convertAndSend(MQConfig.TOPIC_EXCHANGE,"topic.key1", msg);
	}

    /**
     * Fanout
     * @Fanout
     */
    public void sendFanoutMessage(MyMessage mm) {
		String msg = RedisService.beanToString(mm);
        log.info("send message:{}" , msg);
		rabbitTemplate.convertAndSend(MQConfig.FANOUT_EXCHANGE,null,msg);
//        rabbitTemplate.convertAndSend(MQConfig.EXCHANGE_TOPIC,"miaosha_*", msg);
    }

//	public void sendTOPMessage(MiaoshaMessage mm) {
//		String msg = RedisService.beanToString(mm);
//		log.info("send message:{}" , msg);
//		rabbitTemplate.convertAndSend(MQConfig.TOPIC_EXCHANGE,"topic.key1",msg);
////        rabbitTemplate.convertAndSend(MQConfig.EXCHANGE_TOPIC,"miaosha_*", msg);
//	}
}
