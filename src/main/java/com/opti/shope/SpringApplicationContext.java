package com.opti.shope;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringApplicationContext implements ApplicationContextAware {
	private static ApplicationContext CONTEXT;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		CONTEXT = applicationContext;

	}
	public static <T> T getBean(String beanID,Class<T> requiredClass) {
		return CONTEXT.getBean(beanID,requiredClass);	
	}
}
