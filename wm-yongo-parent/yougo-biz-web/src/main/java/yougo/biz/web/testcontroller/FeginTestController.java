package yougo.biz.web.testcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import redis.clients.jedis.Jedis;
import yougo.util.properties.PropertyUtil;
import yougo.util.redis.RedisUtil;

/**
 * 
 * description:fegin 方式调用 date: 2018年5月31日 下午6:16:37
 * 
 * @author nicr
 */
@Controller
@RequestMapping("fweb")
public class FeginTestController {

	private static final Jedis jedis = new Jedis();
	private static final String LOCK_SUCCESS = "OK";
	private static final String SET_IF_NOT_EXIST = "NX";
	private static final String SET_WITH_EXPIRE_TIME = "EX";
	private static final Long RELEASE_SUCCESS = 1L;

	/**
	 * 被调用的接口服务
	 */
//	@Autowired
//	TestInterface testInterface;
//
//	@RequestMapping("test")
//	@ResponseBody
//	public String test() {
//		return testInterface.test(1);
//	}
//
//	@RequestMapping("test2")
//	@ResponseBody
//	public String test2() {
//		UcsUserPO ucsUser = new UcsUserPO();
//		ucsUser.setName("GTR");
//		return testInterface.test2(ucsUser);
//	}

	/**
	 * 尝试获取分布式锁
	 * 
	 * @param jedis
	 *            Redis客户端
	 * @param lockKey
	 *            锁
	 * @param requestId
	 *            请求标识
	 * @param expireTime
	 *            超期时间
	 * @return 是否获取成功
	 */
	@RequestMapping("redisLock")
	@ResponseBody
	public String tryGetDistributedLock(String lockKey, String requestId, int expireTime) {
		boolean lockFlag = true;
		// 循环等待拿锁
		while (lockFlag) {
			if (RedisUtil.setLock(lockKey, requestId, expireTime)) {
				// 处理业务
				System.out.println("do something");
//				testInterface.testRedisLock();
				// 释放锁
				boolean flag = RedisUtil.releaseRedisLock(lockKey, requestId);
				System.out.println(flag+":"+requestId);
				lockFlag = false;
			}
		}
		return "SUCCESS";

	}

	/**
	 * 
	 * description: 给lockKey字段加锁
	 * 
	 * @param lockKey
	 *            加锁的key
	 * @param requestId
	 *            用于解锁时唯一字段
	 * @param expireTime
	 *            超时时间
	 * @return
	 * @author nicr date: 2018年6月21日 下午2:57:11
	 */
//	private boolean getLock(String lockKey, String requestId, int expireTime) {
//		String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
//		return StringUtils.equals(LOCK_SUCCESS, result);
//	}

	/**
	 * 释放分布式锁
	 * 
	 * @param lockKey
	 *            锁
	 * @param requestId
	 *            请求标识
	 * @return 是否释放成功
	 */
//	public static boolean releaseDistributedLock(String lockKey, String requestId) {
//		// 保证不会因为超时把不属于本进程的锁解掉
//		String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
//		Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));
//		if (RELEASE_SUCCESS.equals(result)) {
//			return true;
//		}
//		return false;
//
//	}
	
	/**
	 * 
	 * description:测试获取数据库value值
	 * @param key
	 * @return
	 * @author nicr
	 * date: 2018年6月22日 下午3:13:05
	 */
	@RequestMapping("getpro")
	@ResponseBody
	public String getpro(String key) {
		try {
			return PropertyUtil.getProperties(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failed";
	}

}
