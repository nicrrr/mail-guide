package yougo.inter.interfaces;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("biz-service")
public interface TestInterface {
	
	@RequestMapping("/service/test")
	public String test();

}
