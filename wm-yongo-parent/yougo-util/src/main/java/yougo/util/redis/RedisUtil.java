package yougo.util.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * 
 * description:redis工具类
 * date: 2018年5月16日 下午3:11:30
 * @author nicr
 */
@SuppressWarnings({ "rawtypes"})
public class RedisUtil {
	
	private RedisUtil(){}
	
	private static RedisTemplate redisTemplate;

	public static void setRedisTemplate(RedisTemplate redisTemplate) {
		RedisUtil.redisTemplate = redisTemplate;
	}
	
	/**
	 * 
	 * description:获取缓存中的值
	 * @param key key值
	 * @return
	 * @author nicr
	 * date: 2018年5月16日 下午5:08:10
	 */
	public static Object get(String key){
		return redisTemplate.opsForValue().get(key);
	}
	
	/**
	 * 
	 * description:
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 * @author nicr
	 * date: 2018年5月16日 下午5:09:57
	 */
	@SuppressWarnings("unchecked")
	public static Object get(String key, long start, long end){
		return redisTemplate.opsForValue().get(key, start, end);
	}
	
	/**
	 * 
	 * description:向缓存中put对象
	 * @param key key值
	 * @param value value值
	 * @author nicr
	 * date: 2018年5月16日 下午5:12:54
	 */
	@SuppressWarnings("unchecked")
	public static void set(Object key, Object value){
		redisTemplate.opsForValue().set(key, value);
	}
	
	/**
	 * 
	 * description:向缓存中put对象，设置超时时间
	 * @param key key值
	 * @param value value值
	 * @param timeout 超时时间(毫秒)
	 * @author nicr
	 * date: 2018年5月16日 下午5:12:24
	 */
	@SuppressWarnings("unchecked")
	public static void set(Object key, Object value, long timeout){
		redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * 
	 * description:计数器，步长为1
	 * @param key 需要计数的key值
	 * @return
	 * @author nicr
	 * date: 2018年5月16日 下午5:39:59
	 */
	@SuppressWarnings("unchecked")
	public static long increment(Object key){
		return redisTemplate.opsForValue().increment(key, 1);
	}
	
}
