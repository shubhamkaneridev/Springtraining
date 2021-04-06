package com.sequence;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.aop.Config;

public class MainApp {

	public static void main(String[] args) {

		AbstractApplicationContext app = new AnnotationConfigApplicationContext(Config.class);

		Operation opt = app.getBean(Operation.class);

		opt.sum(45, 5);

	}

}
