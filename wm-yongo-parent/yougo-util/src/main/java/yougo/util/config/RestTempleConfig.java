package yougo.util.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import yougo.util.client.RestTemplateUtil;

@Configuration
public class RestTempleConfig {
	
//	private RestTempleConfig(){}
	
	@Bean
	public RestTemplate getRestTemple(){
		RestTemplate restTemplate = new RestTemplate ();
		RestTemplateUtil.setRestTemplate(restTemplate);
		return restTemplate;
	}

}
