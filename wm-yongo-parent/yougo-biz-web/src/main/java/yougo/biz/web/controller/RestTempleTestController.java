package yougo.biz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import redis.clients.jedis.Jedis;
import yougo.entity.test.User;
import yougo.util.client.RestTemplateUtil;
import yougo.util.mq.ActiveMqUtil;
import yougo.util.redis.RedisUtil;

@Controller
@RequestMapping("rweb")
public class RestTempleTestController {
	
	private static final Jedis jedis = new Jedis();
	
	private static final long expired = 1000;//1秒超时
	
	/**
	 * 
	 * description: get请求方式，String.class为responseType
	 * getForEntity有三个重载方法，responseType=ResponseEntity<T>[T为调用方法的responseType]
	 * getForEntity的第三个参数可以为：new Object[]{param1, param2}，Map<String, ?>，空。当第三个参数不为空时，
	 * 地址中的参数需已站位形式指定，且必须与数组中的参数位置对应，与Map中的key对应
	 * @return
	 * @author nicr
	 * date: 2018年5月17日 上午11:07:44
	 */
	@GetMapping("getForEntity1")
	@ResponseBody
	public String getForEntity(){
		RestTemplate restTemplate = RestTemplateUtil.getRestTemplate();
		return restTemplate.getForEntity("http://localhost:9010/service/getForEntity1?id=1&name=2", String.class).getBody();
	}
	
	/**
	 * 
	 * description:返回的为object对象
	 * @return
	 * @author nicr
	 * date: 2018年5月17日 上午11:59:45
	 */
	@GetMapping("getForObject1")
	@ResponseBody
	public String getForObject(){
		RestTemplate restTemplate = RestTemplateUtil.getRestTemplate();
		User user = restTemplate.getForObject("http://localhost:9010/service/getForObject1?id=1&name=2", User.class);
		return user.toString();
	}
	
	/**
	 * 
	 * description: post请求
	 * (同get请求)
	 * @return
	 * @author nicr
	 * date: 2018年5月17日 下午2:35:16
	 */
	@GetMapping("postForObject1")
	@ResponseBody
	public String postForEntity1(){
		RestTemplate restTemplate = RestTemplateUtil.getRestTemplate();
		User reqUser = new User();
		reqUser.setId(1);
		reqUser.setName("2");
		User user = restTemplate.postForObject("http://localhost:9010/service/postForObject1", reqUser, User.class);
		return user.toString();
	}
	
	/**
	 * PUT,DELETE请求暂无
	 */
	
	/**
	 * 
	 * description:测试类
	 * @return
	 * @author nicr
	 * date: 2018年5月18日 上午9:56:06
	 */
	@GetMapping("test")
	@ResponseBody
	public String test(){
		User reqUser = new User();
		reqUser.setId(1);
		reqUser.setName("2");
		long i = RedisUtil.increment("test");
		ActiveMqUtil.pushToQueue("queue-test", "test");
//		BaseResult<User> result = (BaseResult<User>) RestTemplateUtil.doBizServicePost(ServiceEnums.BIZSERVICETEST.getServerName(), reqUser, User.class);
//		return result.getModel().toString();
		return "success";
	}
	
	@RequestMapping("redisLock")
	@ResponseBody
	public String redisLock(){
		boolean lockFlag = true;
		//循环等待拿锁
        while(lockFlag){
            if(getLock(jedis,"o2o")){
            	lockFlag = false; 	
            }
        }
        //处理业务
        System.out.println("do something");
        try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        //释放锁
        releaseLock(jedis, "o2o");
		return "success";
	}
	
	//获取锁
	private boolean getLock(Jedis jedis, String lock){
		boolean flag = false;
		long value = System.currentTimeMillis() + expired + 1;        
        long acquired = jedis.setnx(lock, String.valueOf(value));  
        jedis.expire(lock, 1);//设置1秒超时  
        if(acquired == 1){
        	flag = true;
        }
        return flag;
	}
	
	//释放锁  
    private void releaseLock(Jedis jedis,String lock) {      
            jedis.del(lock);   
    }
}
