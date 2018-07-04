package yougo.biz.web.testcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import yougo.biz.web.inter.ITestInterface;

@RestController
public class Java8TestController {
	
	@Autowired
	ITestInterface iTestInterface;
	
	/**
	 * description:测试java8新接口使用(接口可有实现)
	 * @return
	 * @author nicr
	 * date: 2018年7月4日 下午4:39:38
	 */
	@RequestMapping("interface")
	public String interfaceTest() {
		iTestInterface.showString("");
		return "SUCCESS";
	}

}
