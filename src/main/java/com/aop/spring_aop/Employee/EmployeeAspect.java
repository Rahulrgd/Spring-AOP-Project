package com.aop.spring_aop.Employee;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class EmployeeAspect {
    
    @Before(value = "execution(* com.aop.spring_aop.Employee.EmployeeController.*(..))")
    public void beforeAspect(JoinPoint joinPoint){
        log.debug("Request to " + joinPoint.getSignature() + " started at " + new Date());
        System.out.println("Request to " + joinPoint.getSignature() + " started at " + new Date());
    }
}
