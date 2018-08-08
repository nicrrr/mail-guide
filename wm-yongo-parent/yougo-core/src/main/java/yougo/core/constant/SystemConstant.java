package yougo.core.constant;

/**
 * 
 * description:系统相关常量(需要更改配置的常量配置如数据库)
 * date: 2018年6月22日 上午11:49:21
 * @author nicr
 */
public class SystemConstant {
	
	/** redis分布锁   **/
	/**
	 * 加锁成功返回值
	 */
	public static final String LOCK_SUCCESS = "OK";
	
	/**
	 * 没有加锁情况下加锁
	 */
	public static final String SET_IF_NOT_EXIST = "NX";
	
	/**
	 * 设置超时时间
	 */
	public static final String SET_WITH_EXPIRE_TIME = "EX";
	
	/**
	 * 解锁成功返回
	 */
	public static final Long RELEASE_SUCCESS = 1L;
	
	/**
	 * 根据唯一标识requestId释放锁，保证解锁的正确
	 */
	public static final String LUA_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";

}
