/**
 *
 */
package com.ztian.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * @author zhailiang
 */
@Slf4j
public class TimeFilter implements Filter {

	/* (non-Javadoc)
	 * @see javax.servlet.filter#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("time filter destroy");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		log.info("time filter start");
		long start = new Date().getTime();
		chain.doFilter(request, response);
		log.info("time filter 耗时:" + (new Date().getTime() - start));
		log.info("time filter finish");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("time filter init");
	}

}
