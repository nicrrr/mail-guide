package yougo.biz.service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("service")
public class TestController {
	
	@RequestMapping("test")
	@ResponseBody
	public String test(){
		return "biz-service-TestController";
	}

}
