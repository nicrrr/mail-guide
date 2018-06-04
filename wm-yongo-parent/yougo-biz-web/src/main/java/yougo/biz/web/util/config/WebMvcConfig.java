package yougo.biz.web.util.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import yougo.biz.web.util.interceptor.BizWebInterceptor;

@Configuration
@EnableAutoConfiguration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	/**
	 * 重写addViewControllers方法，引导到index页面
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		super.addViewControllers(registry);
		registry.addViewController("/").setViewName("/index");
	}
	
	/**
	 * 重写addInterceptors方法，添加自定义拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//加入自定义拦截器
		registry.addInterceptor(new BizWebInterceptor());
	}

}
