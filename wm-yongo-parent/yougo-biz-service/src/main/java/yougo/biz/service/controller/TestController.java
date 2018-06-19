package yougo.biz.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import yougo.entity.po.UcsUserPO;

/**
 * 
 * description:测试类，提供给biz-web调用
 * date: 2018年6月4日 上午9:54:43
 * @author nicr
 */
@Controller
@RequestMapping("service")
public class TestController {
	
	@RequestMapping("test")
	@ResponseBody
	public String test(Integer i){
		return "biz-service-TestController-get+"+i;
	}
	
	@RequestMapping("test2")
	@ResponseBody
	public String test2(@RequestBody UcsUserPO ucsUserPO){
		return "biz-service-TestController-post+" + ucsUserPO.getName();
	}

}
