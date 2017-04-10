package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 拦截器配置
 * @author zhuyumeng
 *
 */
public class AuthorityInterceptor extends HandlerInterceptorAdapter{

	private static Logger log = Logger.getLogger(AuthorityInterceptor.class);
	

	private long currentTime;
	/**
	 * 发送请求之前
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		currentTime = System.currentTimeMillis();
		log.info("当前请求的路径为:["+((HttpServletRequest) request).getRequestURI()+"]");
		return true;
	}
	/**
	 * 处理请求之后
	 */
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{
	  
		if(modelAndView!=null&&log.isInfoEnabled()){
			log.info("当前返回的视图为:[....view/"+modelAndView.getViewName()+".jsp]");
		}
		log.info("请求时间为:["+(System.currentTimeMillis()-currentTime)+"ms]");
	}
}
