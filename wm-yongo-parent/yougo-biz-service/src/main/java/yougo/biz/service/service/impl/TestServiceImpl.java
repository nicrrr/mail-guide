package yougo.biz.service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import yougo.biz.service.dao.TestMapper;
import yougo.biz.service.service.TestService;
import yougo.entity.po.UcsUserPO;

@Service
public class TestServiceImpl implements TestService{
	
	@Autowired
	TestMapper testMapper;

	@Override
	public int insertTest() {
		UcsUserPO ucsUserPO = new UcsUserPO();
		ucsUserPO.setName("jugg");
		ucsUserPO.setAddress("18");
		return testMapper.insertTest(ucsUserPO);
	}

	@Override
	public int updateTest() {
		return testMapper.updateTest();
	}

}
