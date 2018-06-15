package yougo.util.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyUtil implements InvocationHandler {
	
	private Object realObject;

	public ProxyUtil(Object realObject) {
		this.realObject = realObject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("dynamic proxy do somthings");
		return method.invoke(realObject, args);
	}

}
