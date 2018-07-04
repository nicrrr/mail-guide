package yougo.util.proxy;

import java.lang.reflect.Proxy;

/**
 * 
 * description:动态代理工厂 date: 2018年6月4日 下午3:27:44
 * 
 * @author nicr
 */
public class JDKDynamicProxyFactory {

	public static Object getProxy(Object realObject) {
		return Proxy.newProxyInstance(realObject.getClass().getClassLoader(), realObject.getClass().getInterfaces(), new ProxyUtil(realObject));
	}

}
