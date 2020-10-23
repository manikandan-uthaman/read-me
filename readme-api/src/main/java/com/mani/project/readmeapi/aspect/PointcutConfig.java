package com.mani.project.readmeapi.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class PointcutConfig {
	
	@Pointcut("execution(* com.mani.project.readmeapi.controller.*.*(..))")
	public void controllerPointcut() {
		// Pointcut declaration. No implementation needed
	}
}
