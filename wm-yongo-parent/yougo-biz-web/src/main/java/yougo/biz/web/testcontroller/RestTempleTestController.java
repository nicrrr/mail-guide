package yougo.biz.web.testcontroller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLContext;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;

import redis.clients.jedis.Jedis;
import yougo.entity.test.User;
import yougo.inter.annotation.MethodForAop;
import yougo.util.client.RestTemplateUtil;
import yougo.util.mq.ActiveMqUtil;
import yougo.util.redis.RedisUtil;

@Controller
@RequestMapping("rweb")
public class RestTempleTestController {
	
	private static final Jedis jedis = new Jedis();
	
	private static final long expired = 1000;//1秒超时
	
	private static int i = 10;
	
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
	
	/**
	 * 
	 * description:setnx方式实现redis分布式锁[数据库锁和zookeeper也可以实现分布式锁]，还可以用set和evil方式实现加锁解锁。
	 * @param id
	 * @return
	 * @author nicr
	 * date: 2018年6月15日 下午4:44:00
	 */
	@RequestMapping("redisLock")
	@ResponseBody
	public String redisLock(String id){
		boolean lockFlag = true;
		String result = jedis.set("00999876", id, "NX", "PX", 3000);
		//循环等待拿锁
//        while(lockFlag){
//            if(getLock(jedis,"00999876")){
//            	//处理业务
//            	System.out.println("do something");
//            	i--;
//            	try {
//            		Thread.sleep(5000);
//            	} catch (InterruptedException e) {
//            		e.printStackTrace();
//            	}
//            	lockFlag = false;
//            	//释放锁
//            	releaseLock(jedis, "00999876");
//            }
//        }
		return result;
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
    
	/**
	 * 
	 * description:get请求。不使用@FeginClient和RestTemplete，使用httpclient方式访问
	 * 			   springcloud对外提供rstful接口
	 * @return
	 * @author nicr
	 * date: 2018年6月5日 下午3:08:28
	 */
	@GetMapping("httpClientGet")
	@ResponseBody
	public String httpClientGet(){
		String result = "nothing";
//		HttpPost httpPost = new HttpPost("http://localhost:9010/service/getForEntity1");
		HttpGet httpGet = new HttpGet("http://localhost:9010/service/getForEntity1?id=1&name=2");
		//CloseableHttpResponse/Client是HttpResponse/HttpClient的最新的实现类
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = getSslHttpClient();
		try {
			response = httpClient.execute(httpGet);
			if(response != null) {
				HttpEntity resEntity = response.getEntity();
				return result = EntityUtils.toString(resEntity, Charset.forName("UTF-8"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			httpGet.releaseConnection();
			if(response!=null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	/**
	 * 
	 * description:post请求。不使用@FeginClient和RestTemplete，使用httpclient方式访问
	 * 			   springcloud对外提供rstful接口
	 * @return
	 * @author nicr
	 * date: 2018年6月5日 下午3:08:28
	 */
	@GetMapping("httpClientPost")
	@ResponseBody
	public String httpClientPost(){
		String result = "nothing";
		HttpPost httpPost = new HttpPost("http://localhost:9010/service/postForObject1");
		//CloseableHttpResponse/Client是HttpResponse/HttpClient的最新的实现类
		CloseableHttpResponse response = null;
		HttpContext localContext = new BasicHttpContext();
		CloseableHttpClient httpClient = getSslHttpClient();
		try {
			User user = new User();
			user.setId(0);
			//设置参数以及编码
			StringEntity entity = new StringEntity(JSON.toJSONString(user), "UTF-8");
//			entity.setContentEncoding(new BasicHeader("Content-Encoding", "UTF-8"));
			//设置请求类型
			entity.setContentType("application/json;charset=UTF-8");
			httpPost.setEntity(entity);
			response = httpClient.execute(httpPost, localContext);
			if(response != null) {
				HttpEntity resEntity = response.getEntity();
				return result = EntityUtils.toString(resEntity, Charset.forName("UTF-8"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			httpPost.releaseConnection();
			if(response!=null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public static CloseableHttpClient getSslHttpClient() {
		//初始化client
		try {
	        return HttpClients.custom().setConnectionManager(getCm()).setDefaultRequestConfig(getRequestConfig()).build();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return HttpClients.createDefault();
	}
	
	/**
	 * 
	 * description:httpclient连接池配置
	 * @return
	 * @throws Exception
	 * @author nicr
	 * date: 2018年6月5日 下午3:27:14
	 */
	@SuppressWarnings("deprecation")
	private static PoolingHttpClientConnectionManager getCm() throws Exception {
		SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
			
			@Override
			public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				return true;
			}
		}).build();
        LayeredConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
        Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
        		.register("https", sslsf)
        		.register("http", new PlainConnectionSocketFactory()).build();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);
        cm.setMaxTotal(Integer.parseInt("50"));
        cm.setDefaultMaxPerRoute(Integer.parseInt("50"));
        return cm;
	}
	
	/**
	 * 
	 * description:请求属性设置
	 * @return
	 * @author nicr
	 * date: 2018年6月5日 下午3:27:29
	 */
	private static RequestConfig getRequestConfig() {
		RequestConfig config = RequestConfig.custom()
				.setConnectionRequestTimeout(6000)
				.setConnectTimeout(6000)
				.setSocketTimeout(6000)
				.build();
		return config;
	}
	
	/**
	 * 
	 * description:@MethodForAop为自定义接口，设置为aop切入的切入点
	 * @return
	 * @author nicr
	 * date: 2018年6月15日 下午3:42:26
	 */
	@MethodForAop
	@RequestMapping("log")
	@ResponseBody
	public Integer log() {
		System.out.println("111");
		return 999;
	}
	
}
