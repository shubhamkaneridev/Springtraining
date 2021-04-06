package com.commons.entity;

import org.aspectj.lang.annotation.AdviceName;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/*
 * @Aspect
 * 
 * @EnableAspectJAutoProxy public class AopCOnfi {
 * 
 * @AfterThrowing("execution(* com.commons.dao.StudentJDBCTemplate.create(..))")
 * public void mypointcut(DataSourceTransactionManager
 * dataSourceTransactionManager) {
 * 
 * }
 * 
 * }
 */
