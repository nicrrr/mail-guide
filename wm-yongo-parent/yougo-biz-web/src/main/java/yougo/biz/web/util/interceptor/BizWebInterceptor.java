package yougo.biz.web.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * Title: BizWebInterceptor 
 * Description: web入口拦截器
 * @author nicr  
 * @date 2018年6月1日
 */
public class BizWebInterceptor extends HandlerInterceptorAdapter{
	
	/**
	 * 拦截请求进行预处理操作
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		checkUrl(request);
//		System.out.println(request.getRequestURL());
		return true;
	}
	
	/**
	 * 处理完业务，在进行页面渲染前可对ModelAndView进行处理
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	
	/**
	 * 用于DispatcherServlet完全处理完请求后被调用。释放资源，根据ex的值进行判断是否发生异常
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
//		checkUrl(request);
	}

	private boolean checkUrl(HttpServletRequest request) {
		boolean flag = false;
		String url = request.getRequestURI();
		return flag;
	}
	
}
