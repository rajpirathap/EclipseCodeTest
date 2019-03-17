package com.raj.demo.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class ThreadComponent {
	

	@Autowired
	ServiceThread sth;
	
	@Scope(value = "prototype")
	public ServiceThread getThread() {
		return sth;
	}
}
