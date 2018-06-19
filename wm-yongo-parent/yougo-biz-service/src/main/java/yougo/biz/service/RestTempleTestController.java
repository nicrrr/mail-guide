package yougo.biz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import yougo.biz.service.service.TestService;
import yougo.entity.test.User;

@Controller
@RequestMapping("service")
public class RestTempleTestController {
	
	@Autowired
	TestService testService;
	
	@GetMapping("getForEntity1")
	@ResponseBody
	public String getForEntity(String id, String name){
		return "id="+id+"name="+name;
	}
	
	@GetMapping("getForObject1")
	@ResponseBody
	public User getForObject(int id, String name){
		User user = new User();
		user.setId(id);
		user.setName(name);
		return user;
	}
	
	@PostMapping("postForObject1")
	@ResponseBody
	public User postForObject1(@RequestBody User user){
		return user;
	}
	
	@GetMapping("testInsert")
	@ResponseBody
	public String testInsert() {
		return testService.insertTest()+"";
	}
}
