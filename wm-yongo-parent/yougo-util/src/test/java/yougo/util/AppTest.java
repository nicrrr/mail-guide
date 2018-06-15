package yougo.util;

import yougo.util.cglib.CglibProxy;
import yougo.util.cglib.Proxyed;
import yougo.util.jdkproxy.TestAction;
import yougo.util.jdkproxy.TestInterface;
import yougo.util.proxy.JDKDynamicProxyFactory;

/**
 * 
 * description:代理测试
 * date: 2018年6月15日 下午3:36:26
 * @author nicr
 */
public class AppTest {
	
	public static void main(String[] args) {
		//jdk代理
		TestAction ta = new TestAction();
		TestInterface ti = (TestInterface) JDKDynamicProxyFactory.getProxy(ta);
		ti.dosomething();
		
		//cglib代理
		CglibProxy cp = new CglibProxy();
		Proxyed p = (Proxyed) cp.getProxy(Proxyed.class);
		p.method();
	}
	
}
