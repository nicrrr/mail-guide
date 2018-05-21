package yougo.util.mq;

import javax.jms.Destination;
import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;

/**
 * 
 * description:
 * date: 2018年5月18日 下午2:43:06
 * @author nicr
 */
public class ActiveMqUtil {
	
	private ActiveMqUtil(){}
	
	private static JmsTemplate jmsTemplate;

	public static JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public static void setJmsTemplate(JmsTemplate jmsTemplate) {
		ActiveMqUtil.jmsTemplate = jmsTemplate;
	}
	
	/**
	 * 
	 * description:根据队列发送信息
	 * @param destination
	 * @param message
	 * @author nicr
	 * date: 2018年5月18日 下午2:52:59
	 */
	public static void sendMessage(Destination destination,Object message){
		jmsTemplate.convertAndSend(destination, message);
	}

	/**
	 * 
	 * description:根据队列名称发送消息
	 * @param destinationName
	 * @param message
	 * @author nicr
	 * date: 2018年5月18日 下午2:53:47
	 */
	public static void sendMessage(String destinationName,Object message){
		jmsTemplate.convertAndSend(destinationName, message);
	}
	
	/**
	 * 
	 * description:向队列中添加消息
	 * @param queueObj
	 * @author nicr
	 * date: 2018年5月18日 下午3:00:30
	 */
	@Bean
	public static void pushToQueue(Object queueObj,Object message){
		if(!(queueObj instanceof Destination)){
			Queue queue = new ActiveMQQueue(queueObj.toString());
			sendMessage(queue, message);
		}else{
			sendMessage((Destination) queueObj, message);
		}
	}
	
}
