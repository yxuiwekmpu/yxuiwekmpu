package org.coderfun.config;

import java.io.IOException;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class DictManagerAop {

	@Autowired
	DictWebFrontBuilder dict;

	/**
	 * 字典改动，重新load
	 * @param joinPoint
	 */
	@After("execution(* org.coderfun.sys.dict.dao.*.*(..))")
	public void reloadDict(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		if (methodName.startsWith("save") || methodName.startsWith("update")||methodName.startsWith("delete")) {
			// 重新从数据库加载字典
			try {
				dict.build();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
