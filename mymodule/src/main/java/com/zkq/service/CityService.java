package com.zkq.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Author zhangkaiqiang
 * @Date 2019/8/2  13:28
 * @Description TODO
 */
@Component
public class CityService implements InitializingBean{


	//The JSR-250
	@PostConstruct
	public void init(){
		System.out.println("life circle call back....................");
	}

	public CityService(){
		System.out.println("在Spring容器初始化时实例化该Service");
	}

	public void getAll(){
		System.out.println("Service..............................");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet................................");
	}
}
