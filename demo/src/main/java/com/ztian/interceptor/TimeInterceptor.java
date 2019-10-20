/**
 * 
 */
package com.ztian.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author zhuweitian
 * 与filter相比，intercortor可以拿到处理请求的controller名称和方法
 * 但无法获取方法实际传入参数
 */
@Slf4j
@ComponentScan
public class TimeInterceptor implements HandlerInterceptor {

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("preHandle");
		HandlerMethod methodHandler = (HandlerMethod) handler;
		log.info((methodHandler).getBean().getClass().getName());
		log.info((methodHandler).getMethod().getName());
		request.setAttribute("startTime", new Date().getTime());
		return true;
	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
	                       ModelAndView modelAndView) throws Exception {
		log.info("postHandle");
		Long start = (Long) request.getAttribute("startTime");
		log.info("time interceptor 耗时:"+ (new Date().getTime() - start));

	}

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		log.info("afterCompletion");
		Long start = (Long) request.getAttribute("startTime");
		log.info("time interceptor 耗时:"+ (new Date().getTime() - start));
		log.info("ex is "+ex);

	}

}
