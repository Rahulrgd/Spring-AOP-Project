package com.aop.spring_aop.Employee;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
        // log.debug("Request to " + joinPoint.getSignature() + " started at " + new Date());
        System.out.println("Request to " + joinPoint.getSignature() + " started at " + new Date());
    }
    
    @After(value = "execution(* com.aop.spring_aop.Employee.EmployeeController.*(..))")
    public void afterAspect(JoinPoint joinPoint){
        // log.debug("Request to " + joinPoint.getSignature() + " started at " + new Date());
        System.out.println("Request to " + joinPoint.getSignature() + " ended at " + new Date());
    }

    @Before(value = "execution(* com.aop.spring_aop.Employee.EmployeeServices.*(..))")
    public void beforeAspectForService(JoinPoint joinPoint){
        // log.debug("Request to " + joinPoint.getSignature() + " started at " + new Date());
        System.out.println("Request to " + joinPoint.getSignature() + " started at " + new Date());
    }
    
    @After(value = "execution(* com.aop.spring_aop.Employee.EmployeeServices.*(..))")
    public void afterAspectForService(JoinPoint joinPoint){
        // log.debug("Request to " + joinPoint.getSignature() + " started at " + new Date());
        System.out.println("Request to " + joinPoint.getSignature() + " ended at " + new Date());
    }

    @AfterThrowing(value = "execution(* com.aop.spring_aop.Employee.EmployeeServices.createEmployee(..))", throwing = "exception")
    public void beforeThrowingAspectForService(JoinPoint joinPoint, Exception exception){
        // log.debug("After Throwing Request to " + joinPoint.getSignature() + " started at " + new Date());
        System.out.println("Businees Logic after throwing an exception: " + exception.getMessage());
    }
    
    @AfterReturning(value = "execution(* com.aop.spring_aop.Employee.EmployeeServices.createEmployee(..))", returning = "employee")
    public void afterReturningAspectForService(JoinPoint joinPoint, Employee employee){
        // log.debug("After Returning Request to " + joinPoint.getSignature() + " started at " + new Date());
        System.out.println("Business logic after successfully execution, new employee id created: " + employee.getId());
    }
}
