package com.zkq.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author zhangkaiqiang
 * @Date 2019/8/7  17:41
 * @Description TODO
 */
@Component
public class MyBeanPostProcess implements BeanPostProcessor {


	@Override
	 public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("cityService")){
			System.out.println("Before...........................");
		}
		return bean;
	}


	@Override
	 public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if(beanName.equals("cityService")){
			System.out.println("After...........................");
		}
		return bean;
	}

}
