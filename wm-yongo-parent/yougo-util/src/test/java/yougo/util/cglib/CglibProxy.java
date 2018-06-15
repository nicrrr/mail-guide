package yougo.util.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor{
	
	private Enhancer enhancer = new Enhancer();
	
	public Object getProxy(Class<?> cla) {
		enhancer.setSuperclass(cla);
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] objs, MethodProxy proxy) throws Throwable {
		System.out.println("before");
		proxy.invokeSuper(obj, objs);
		System.out.println("after");
		return null;
	}

}
