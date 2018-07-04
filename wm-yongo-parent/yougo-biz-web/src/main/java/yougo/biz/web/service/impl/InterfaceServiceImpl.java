package yougo.biz.web.service.impl;

import org.springframework.stereotype.Service;

import yougo.biz.web.inter.ITestInterface;

@Service
public class InterfaceServiceImpl implements ITestInterface{

	@Override
	public void showString(String message) {
		System.out.println(getString());
	}

}
