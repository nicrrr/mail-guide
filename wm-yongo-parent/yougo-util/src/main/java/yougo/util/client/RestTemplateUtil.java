package yougo.util.client;

import org.springframework.web.client.RestTemplate;

import yougo.core.urls.ServiceUrls;
import yougo.entity.BaseResult;

/**
 * 
 * description:RestTemplate工具类
 * date: 2018年5月17日 下午2:45:53
 * @author nicr
 */
public class RestTemplateUtil {
	
	public static RestTemplate restTemplate;
	
	public static void setRestTemplate(RestTemplate restTemplate) {
		RestTemplateUtil.restTemplate = restTemplate;
	}
	
	public static RestTemplate getRestTemplate() {
		return restTemplate;
	}

	/**
	 * 
	 * description:调用biz-service中的服务
	 * @param serviceName 需要请求的服务名称
	 * @param request
	 * @param cla
	 * @return
	 * @author nicr
	 * date: 2018年5月18日 上午10:36:09
	 */
	public static BaseResult<?> doBizServicePost(String serviceName, Object request, Class<?> cla){
		BaseResult<?> baseResult = new BaseResult<>();
		try{
			Object object = restTemplate.postForObject(ServiceUrls.BIZSERVICE.getPort() + serviceName, request, cla);
			baseResult.setCode("0000");
			baseResult.setModel(object);
		}catch(Exception e){
			baseResult.setCode("9999");
		}
		return baseResult;
	}
}
