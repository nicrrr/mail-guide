package yougo.biz.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yougo.inter.interfaces.TestInterface;

@Controller
@RequestMapping("fweb")
public class FeginTestController {
	
	@Autowired
	TestInterface testInterface;
	
	@RequestMapping("test")
	@ResponseBody
	public String test() {
		return testInterface.test();
	}

}
