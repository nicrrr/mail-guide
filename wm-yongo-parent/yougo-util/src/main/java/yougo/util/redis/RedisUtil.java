package yougo.util.redis;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.Jedis;
import yougo.core.constant.SystemConstant;

/**
 * 
 * description:redis工具类
 * date: 2018年5月16日 下午3:11:30
 * @author nicr
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class RedisUtil {
	
	private RedisUtil(){}
	
	private static RedisTemplate redisTemplate;
	
	private static Jedis jedis;

	public static void setRedisTemplate(RedisTemplate redisTemplate) {
		RedisUtil.redisTemplate = redisTemplate;
	}
	
	public static void setJedis(Jedis jedis) {
		RedisUtil.jedis = jedis;
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
	public static long increment(Object key){
		return redisTemplate.opsForValue().increment(key, 1);
	}
	
	/**
	 * 
	 * description:删除数据
	 * @param key
	 * @author nicr
	 * date: 2018年6月20日 上午11:08:16
	 */
	public static void delete(Object key){
		redisTemplate.delete(key);
	}
	
	/**
	 * 
	 * description:给key加锁
	 * @param keyLock 锁
	 * @param requestId 唯一id(用于删除key)
	 * @param timeOut 超时时间,单位/秒
	 * @return 返回OK加锁成功，否则失败
	 * @author nicr
	 * date: 2018年6月22日 下午2:18:29
	 */
	public static boolean setLock(String keyLock, String requestId, int timeOut) {
		return StringUtils.equals(SystemConstant.LOCK_SUCCESS, jedis.set(keyLock, requestId, SystemConstant.SET_IF_NOT_EXIST, SystemConstant.SET_WITH_EXPIRE_TIME, timeOut));
	}
	
	/**
	 * 
	 * description:释放redis锁
	 * @param lockKey 锁
	 * @param requestId 唯一id(用于删除key)
	 * @return 返回1释放锁成功，0释放锁失败
	 * @author nicr
	 * date: 2018年6月22日 下午2:25:03
	 */
	public static boolean releaseRedisLock(String lockKey, String requestId) {
		// 保证不会因为超时把不属于本进程的锁解掉
		String script = SystemConstant.LUA_SCRIPT;
		Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
		if (SystemConstant.RELEASE_SUCCESS.equals(result)) {
			return true;
		}
		return false;

	}
	
}
