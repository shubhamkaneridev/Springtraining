package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import com.aop.entity.MYException;

@Aspect
@EnableAspectJAutoProxy
@Component
public class Human {

	/*
	 * @Before("myPointCuts()") public void wakeUp(JoinPoint j) {
	 * System.out.println("Good Morning ! " +j.getSignature().getName()); }
	 * 
	 * @After("myPointCuts()") public void sleep() {
	 * System.out.println("Good Night!"); }
	 * 
	 * 
	 * 
	 * 
	 * @Pointcut("execution(public * study*(..))") public void myPointCuts() {}
	 * 
	 */

	@AfterReturning(pointcut = "execution( * study*(..))", returning = "value")
	public void Wakeup(int value) {
		System.out.println("Study method return value " + value);
	}

	/*
	 * @AfterThrowing(pointcut = "execution( * doOperationSomething())" ,throwing =
	 * "ex" ) public void Wakeup(MYException ex) {
	 * System.out.println("This is my throw Exception " +ex);
	 * 
	 * }
	 */

	@AfterThrowing(pointcut = "execution( * doOperationSomething())")
	public void Wakeup(JoinPoint j) {
		System.out.println("This is my throw Exception " + j.getSignature());
	}

	@Around("execution( int rankOfVideo(int,int))")
	public Object aroundAdvice(ProceedingJoinPoint jp) {
		Object[] objArgs = jp.getArgs();
		
		objArgs[0]=200;

		Object res = null;
		try {
			res = jp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		System.out.println(res);
		return 3000;

	}

}
