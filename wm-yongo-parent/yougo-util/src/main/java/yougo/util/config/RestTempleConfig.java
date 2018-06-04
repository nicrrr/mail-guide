package yougo.util.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import yougo.util.client.RestTemplateUtil;

/**
 * 
 * description:系统初始化创建服务间调用的RestTemplate的bean
 * date: 2018年6月4日 上午11:56:33
 * @author nicr
 */
@Configuration
public class RestTempleConfig {
	
//	private RestTempleConfig(){}
	
	/**
	 * 
	 * description:生成RestTemplate的bean
	 * @return
	 * @author nicr
	 * date: 2018年6月4日 上午11:57:06
	 */
	@Bean
	public RestTemplate getRestTemple(){
		RestTemplate restTemplate = new RestTemplate ();
		RestTemplateUtil.setRestTemplate(restTemplate);
		return restTemplate;
	}

}
