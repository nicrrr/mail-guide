package yougo.util.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisPoolConfig;
import yougo.util.redis.RedisUtil;

/**
 * 
 * description:项目初始化时创建redis使用对象
 * date: 2018年5月16日 下午4:57:41
 * @author nicr
 */
@Configuration
@EnableConfigurationProperties
public class RedisConfig {
	
	@Value("${spring.redis.host}")
	private String hostName;
	
	@Value("${spring.redis.port}")
	private int port;
	
	@Value("${spring.redis.timeout}")
	private int timeout;
	
	/**
	 * 
	 * description:读取配置文件中redis的配置
	 * @return
	 * @author nicr
	 * date: 2018年5月16日 下午4:21:14
	 */
	@Bean
	@ConfigurationProperties(prefix="spring.redis")
	public JedisPoolConfig getRedisConfig(){
		JedisPoolConfig conf = new JedisPoolConfig();
		return conf;
	}

	/**
	 * 
	 * description:创建redis连接工厂
	 * @return
	 * @author nicr
	 * date: 2018年5月16日 下午4:29:41
	 */
	@Bean
	@ConfigurationProperties(prefix="spring.redis")
	public JedisConnectionFactory getRedisConFactory(){
		JedisConnectionFactory factory = new JedisConnectionFactory();
		JedisPoolConfig config = getRedisConfig();  
        factory.setPoolConfig(config);  
        factory.setHostName(hostName);
        factory.setPort(port);
        factory.setTimeout(timeout);
        return factory; 
	}
	
	/**
	 * 
	 * description:创建redis操作bean
	 * @return
	 * @author nicr
	 * date: 2018年5月16日 下午4:50:06
	 */
	@Bean
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public RedisTemplate getRedisTemplate(){
		RedisTemplate temp = new RedisTemplate();
		temp.setConnectionFactory(getRedisConFactory());
		//确保bean的属性设置完后再调用
		temp.afterPropertiesSet();
		//设置key的序列化方式
		RedisSerializer stringSerial = new StringRedisSerializer();
		temp.setKeySerializer(stringSerial);
		RedisUtil.setRedisTemplate(temp);
		return temp;
	}

}
