package yougo.inter.interfaces;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * description:调用biz-service服务中的接口/service/test
 * date: 2018年5月31日 下午6:17:16
 * @author nicr
 */
@FeignClient("biz-service")
public interface TestInterface {
	
	@RequestMapping("/service/test")
	public String test();

}
