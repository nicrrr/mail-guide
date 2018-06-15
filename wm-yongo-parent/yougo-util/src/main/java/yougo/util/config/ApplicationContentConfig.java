package yougo.util.config;

import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class ApplicationContentConfig implements ApplicationContextAware{

	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ApplicationContentConfig.applicationContext = applicationContext;
	}
	
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	public static Object getBean(String name) {
		return applicationContext.getBean(name);
	}
	
	public static Object getBean(Class<?> cla) {
		return applicationContext.getBean(cla);
	}

}
