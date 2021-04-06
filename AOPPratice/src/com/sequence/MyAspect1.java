package com.sequence;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy
@Component
public class MyAspect1 {
	@Before("execution(* * (..))")
	public void  advice()
	{
		System.out.println(" advice  -- my Aspect 1");
		
	}
}
