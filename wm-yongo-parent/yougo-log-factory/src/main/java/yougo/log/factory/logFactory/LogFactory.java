package yougo.log.factory.logFactory;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * 
 * description:
 * date: 2018年6月15日 上午10:36:14
 * @author nicr
 */
//@EnableAspectJAutoProxy(proxyTargetClass=true)
@Aspect
@Component
public class LogFactory {
	
	//切入点注解  
    @Pointcut("execution(* yongo.biz.web.testcontroller.*.*(..))")  
    public void cut(){
    	
    	
    	
    }
	
	@Before(value = "cut()")
	public void before() {
		System.out.println("this is aop before");
	}
	
}
