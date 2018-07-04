package yougo.util.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 
 * description:aop测试类
 * date: 2018年6月15日 下午3:21:27
 * @author nicr
 */
@Aspect
@Component
public class AspectJTest {
	
	private Logger log = Logger.getLogger(AspectJTest.class);
	
	/**
	 * 
	 * description:切入点：自定义注解@annotation：MethodForAop[间接调用不生效]
	 * @author nicr
	 * date: 2018年6月15日 下午3:26:25
	 */
	@Pointcut(value = "@annotation(yougo.inter.annotation.MethodForAop)")  
	public void cut(){
	}
	
	/**
	 * 
	 * description:目标方法前
	 * @param joinPoint
	 * @author nicr
	 * date: 2018年6月15日 下午3:26:21
	 */
	@Before(value = "cut()")
	public void before(final JoinPoint joinPoint) {
		log.info("------the " + joinPoint.getTarget().getClass().getSimpleName() + " is start------");
	}
	
	/**
	 * 
	 * description:目标方法后
	 * @param joinPoint
	 * @author nicr
	 * date: 2018年6月15日 下午3:27:25
	 */
	@After(value = "cut()")
	public void after(final JoinPoint joinPoint) {
		log.info("------the " + joinPoint.getTarget().getClass().getSimpleName() + " is end--------");
	}
	
	/**
	 * 
	 * description:目标方法返回后
	 * @param joinPoint
	 * @param rvt 目标方法返回值[rvt必须和目标方法返回值一致，不确定类型可用超类Object]
	 * @author nicr
	 * date: 2018年6月15日 下午3:27:29
	 */
	@AfterReturning(returning="rvt", value="cut()")
    public void afterReturning(final JoinPoint joinPoint, Object rvt) {
    }
	
}
