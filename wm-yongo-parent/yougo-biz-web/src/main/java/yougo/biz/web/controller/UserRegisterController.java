package yougo.biz.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * description:用户注册controller
 * date: 2018年6月1日 下午2:08:15
 * @author nicr
 */
@Controller
@RequestMapping("userRegister")
public class UserRegisterController {
	
	@RequestMapping("test")
	@ResponseBody
	public String test() {
		return "success";
	}
	
}
