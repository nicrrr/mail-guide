package yougo.util.config;

import java.util.ArrayList;
import java.util.Arrays;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

import yougo.util.mq.ActiveMqUtil;

/**
 * 
 * description: 初始化mq工具类
 * date: 2018年5月18日 上午11:53:00
 * @author nicr
 */
@Configuration
@EnableAutoConfiguration
//用于自动注入JmsTemplate
//@EnableJms
public class AMQConfig {
	
	@Value("${spring.activemq.broker-url}")
	private String url;
	
	@Value("${spring.activemq.user}")
	private String user;
	
	@Value("${spring.activemq.password}")
	private String password;
	
	@Value("${spring.profiles.active}")
	private String exclusiveConsumer;
	
//	@Autowired
//	private JmsTemplate jmsTemplate;
	
	/**
	 * 
	 * description:设置amq连接工厂
	 * @return
	 * @author nicr
	 * date: 2018年5月18日 下午2:23:25
	 */
	//加上@bean启动会报错：多创建一个bean的实例
	@Bean
	public ActiveMQConnectionFactory amqConnectionFactory(){
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(user, password, url);
		//允许关闭安全检查
		activeMQConnectionFactory.setTrustAllPackages(true);
		//允许跳过安全检查的类
		activeMQConnectionFactory.setTrustedPackages(new ArrayList<String>(Arrays.asList(
				"yougo.entity,java.lang,javax.security,java.util,org.apache.activemq,"
				+ "org.fusesource.hawtbuf,com.thoughtworks.xstream.mapper".split(","))));
		if(StringUtils.equals("dev", exclusiveConsumer)){
			//设置专门的消费者
			activeMQConnectionFactory.setExclusiveConsumer(true);
		}
		return activeMQConnectionFactory;
	}
	
	/**
	 * 
	 * description:缓存连接工厂(如session、producer)
	 * @return
	 * @author nicr
	 * date: 2018年5月18日 下午2:26:54
	 */
	@Bean
	public CachingConnectionFactory amqCachingConnectionFactory(){
		return new CachingConnectionFactory(amqConnectionFactory());
	}
	
	/**
	 * 
	 * description:生成mq操作对象
	 * @return
	 * @author nicr
	 * date: 2018年5月18日 下午2:34:39
	 */
	@Bean
	public JmsTemplate getJmsTemplate(){
		JmsTemplate jmsTemplate = new JmsTemplate(amqCachingConnectionFactory());
		ActiveMqUtil.setJmsTemplate(jmsTemplate);
		return jmsTemplate;
	}
	
}
