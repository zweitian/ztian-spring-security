package com.ztian.config;

import com.ztian.filter.TimeFilter;
import com.ztian.interceptor.TimeInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhuweitian
 * @date 2019/10/20
 */
@Configuration
@Slf4j
public class WebConfig extends WebMvcConfigurerAdapter {
	@Autowired
	private TimeInterceptor timeInterceptor;

	@Bean
	public FilterRegistrationBean timeFilter() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();

		TimeFilter timeFilter = new TimeFilter();
		registrationBean.setFilter(timeFilter);

		List<String> urls = new ArrayList<>();
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);

		return registrationBean;

	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		log.info("{}", timeInterceptor);
		registry.addInterceptor(timeInterceptor);
	}
}
