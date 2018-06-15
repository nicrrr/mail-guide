//package yougo.biz.web.testcontroller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import yougo.entity.po.UcsUser;
//import yougo.inter.interfaces.TestInterface;
//
///**
// * 
// * description:fegin 方式调用
// * date: 2018年5月31日 下午6:16:37
// * @author nicr
// */
//@Controller
//@RequestMapping("fweb")
//public class FeginTestController {
//	
//	/**
//	 * 被调用的接口服务
//	 */
//	@Autowired
//	TestInterface testInterface;
//	
//	@RequestMapping("test")
//	@ResponseBody
//	public String test() {
//		return testInterface.test(1);
//	}
//	
//	@RequestMapping("test2")
//	@ResponseBody
//	public String test2() {
//		UcsUser ucsUser = new UcsUser();
//		ucsUser.setName("GTR");
//		return testInterface.test2(ucsUser);
//	}
//
//}
