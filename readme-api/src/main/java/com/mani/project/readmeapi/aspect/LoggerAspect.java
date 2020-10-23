package com.mani.project.readmeapi.aspect;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggerAspect {

	private static Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

	@Before(value = "com.mani.project.readmeapi.aspect.PointcutConfig.controllerPointcut()")
	public void beforeController(JoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		logger.info("Execution of {}.{} method started", method.getDeclaringClass().getSimpleName(), method.getName());
	}

	@AfterThrowing(value = "com.mani.project.readmeapi.aspect.PointcutConfig.controllerPointcut()", throwing = "ex")
	public void exceptionInController(JoinPoint joinPoint, Exception ex) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		logger.error("Exception thrown in {}.{} method", method.getDeclaringClass().getSimpleName(), method.getName());
		logger.error(ex.getMessage(), ex);
	}	
}
