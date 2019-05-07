package com.gdpost.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class SpringUtil {
	private static ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
	public static Object getBean(String serviceName){
          return context.getBean(serviceName);
    }
}
