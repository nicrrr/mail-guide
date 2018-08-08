package yougo.inter.interfaces;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import yougo.entity.po.UcsUserPO;

/**
 * 
 * description:调用biz-service服务中的接口/service/test
 * date: 2018年5月31日 下午6:17:16
 * @author nicr
 */
@FeignClient("biz-service")
public interface TestInterface {
	
	/**
	 * 
	 * description:get方法传参必须给参数加上@RequestParam("xx"),xx为被调用接口的参数名称(被调用接口上可以不加@RequestParam)
	 * @param i
	 * @return
	 * @author nicr
	 * date: 2018年6月4日 下午3:01:47
	 */
//	@RequestMapping(value = "/service/test", method = RequestMethod.GET)
//	@ResponseBody
//	public String test(@RequestParam("i") Integer i);
	
	@GetMapping(value = "/service/test")
	@ResponseBody
	public String test(@RequestParam("i") Integer i);
	
	/**
	 * 
	 * description:post请求两边必须都加上@RequestBody(复合类型使用)
	 * @param ucsUserPO
	 * @return
	 * @author nicr
	 * date: 2018年6月4日 下午3:18:05
	 */
//	@RequestMapping(value = "/service/test2", method = RequestMethod.POST)
//	@ResponseBody
//	public String test2(@RequestBody UcsUser ucsUser);
	
	@PostMapping(value = "/service/test2")
	@ResponseBody
	public String test2(@RequestBody UcsUserPO ucsUserPO);
	
	/**
	 * 
	 * description:用于测试分布式锁
	 * @param i
	 * @return
	 * @author nicr
	 * date: 2018年6月21日 下午3:14:39
	 */
	@GetMapping(value = "/service/testUpdate")
	@ResponseBody
	public String testRedisLock();

}
